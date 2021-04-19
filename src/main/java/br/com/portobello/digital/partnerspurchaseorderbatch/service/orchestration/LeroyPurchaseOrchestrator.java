package br.com.portobello.digital.partnerspurchaseorderbatch.service.orchestration;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order.OrderResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order.LeroyBatchesInfo;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.order.LeroyBatchesRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.batch.LeroyPurchaseOrderBatchService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.facade.LeroyBatchFacadeService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.leroy.LeroyPurchaseOrderService;
import br.com.portobello.digital.partnerspurchaseorderbatch.utils.Constants;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeroyPurchaseOrchestrator {

    Logger logger = LoggerFactory.getLogger(LeroyPurchaseOrchestrator.class);

    @Autowired
    private LeroyBatchFacadeService batchFacadeService;

    @Autowired
    private LeroyPurchaseOrderBatchService leroyBatchService;

    @Autowired
    private LeroyPurchaseOrderService leroyPurchaseOrderService;

    @Autowired
    private LeroyBatchesRepository batchesRepository;

    public void start() {
        logger.info("Starting PBA Purchase Order Integration");
        batchFacadeService.clearDocuments();
        var integrationPeriod = batchFacadeService.getIntegrationPeriod();
        OrderResponseLeroyDTO purchaseOrders = new OrderResponseLeroyDTO();
        boolean hasNextPage = false;
        do {
            logger.info("Getting purchase order from Leroy. Initial Order Creation Date: {} , Final Order Creation Date: {}", integrationPeriod.getBegin(), integrationPeriod.getEnd(), integrationPeriod.getOffset());
            try {
                purchaseOrders = leroyBatchService.getOrderLeroy(integrationPeriod);
            } catch (FeignException e) {
                logger.info("[LEROY - GET ORDER] Localized Message : {} , Message : {} , Integration period : {}", e.getLocalizedMessage(), e.getMessage(), integrationPeriod.toString());
            }
            if (purchaseOrders.getItems() != null) {
                purchaseOrders.getItems().stream().forEach(leroyBatchService::saveAndPublish);
            }
            if (purchaseOrders.getHeader().getTotal() != null) {
                hasNextPage = purchaseOrders.getHeader().getTotal() > purchaseOrders.getHeader().getOffset() + purchaseOrders.getHeader().getLimit();
            }
            logger.info("Saving Leroy purchase order into database");


            logger.info("Response info: Total orders {}, Processed orders {}, hasNextPage {}",
                    purchaseOrders.getHeader().getTotal(), purchaseOrders.getHeader().getOffset(), hasNextPage);
            integrationPeriod.setOffset(integrationPeriod.getOffset() + Constants.LEROY_LIMIT_ITENS_PER_PAGE);
            logger.info("Saving Leroy purchase order into database");
            //purchaseOrders = leroyBatchService.filterActivePurchases(purchaseOrders);

        } while (hasNextPage);
        logger.info("Ending orchestration");
        batchFacadeService.clearDocuments();
        batchesRepository.save(new LeroyBatchesInfo(integrationPeriod.getEnd()));
        logger.info("Orchestration finished");
    }
}
