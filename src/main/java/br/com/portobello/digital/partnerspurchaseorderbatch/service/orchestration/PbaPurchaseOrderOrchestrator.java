package br.com.portobello.digital.partnerspurchaseorderbatch.service.orchestration;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order.PbaBatchesOrderInfo;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.pba.order.PbaBatchesOrderRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.batch.PbaPurchaseOrderBatchService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.facade.PbaBatchFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PbaPurchaseOrderOrchestrator {

    Logger logger = LoggerFactory.getLogger(PbaPurchaseOrderOrchestrator.class);

    @Autowired
    private PbaBatchFacadeService batchFacadeService;

    @Autowired
    private PbaPurchaseOrderBatchService pbaBatchService;

    @Autowired
    private PbaBatchesOrderRepository batchesRepository;

    public void start() {
        logger.info("Starting PBA Purchase Order Integration");
        batchFacadeService.clearDocuments();
        var integrationPeriod = batchFacadeService.getIntegrationPeriod();
        logger.info("Getting purchase order from PBA. Transaction date: {}", integrationPeriod.getBegin());
        List<PurchaseOrderPbaDTO> purchaseOrders = pbaBatchService.getOrderPba(integrationPeriod.getBegin());
        logger.info("Saving PBA purchase order into database");
        batchFacadeService.saveNewItens(purchaseOrders);
        logger.info("Starting to integrate with rabbit");
        pbaBatchService.integrate();
        //purchaseOrders.stream().forEach(pbaBatchService::completeAndPublish);
        logger.info("Ending orchestration");
        batchesRepository.deleteAll();
        batchesRepository.save(new PbaBatchesOrderInfo(integrationPeriod.getEnd()));
        logger.info("Orchestration finished");
    }


}
