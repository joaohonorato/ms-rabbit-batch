package br.com.portobello.digital.partnerspurchaseorderbatch.service.orchestration;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductVMIResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.reponse.EstoqueEBSResponseDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierStockRequestDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order.LeroyBatchItem;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.vmi.LeroyBatchNewItemVMI;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.order.LeroyBatchItemRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.batch.LeroyVMIBatchService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.facade.LeroyBatchFacadeService;
import br.com.portobello.digital.partnerspurchaseorderbatch.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeroyVMIOrchestrator {
    Logger logger = LoggerFactory.getLogger(LeroyVMIOrchestrator.class);

    @Autowired
    private LeroyBatchFacadeService batchFacadeService;

    @Autowired
    private LeroyVMIBatchService vmiBatchService;

    @Autowired
    private LeroyBatchItemRepository batchItemRepository;

    public void start() {
        logger.info("Starting Leroy VMI Integration");
        batchFacadeService.clearVMIDocuments();
        //var integrationPeriod = batchFacadeService.getVMIIntegrationPeriod();
        logger.info("Getting stock VMI from Leroy. Transaction id: {}", Constants.PORTOBELLO_LEROY_FISCAL_ID);
        List<ProductVMIResponseLeroyDTO> stockLeroy = vmiBatchService.getStockVMIFromLeroy(Constants.PORTOBELLO_LEROY_FISCAL_ID);
        List<EstoqueEBSResponseDTO> stockEbs = vmiBatchService.getStockFromEbs(stockLeroy);
        logger.info("Saving RAW Leroy and EBS Info");
        batchItemRepository.save(new LeroyBatchItem(stockLeroy, stockEbs));
        logger.info("Creating Payload Request");
        SupplierStockRequestDTO supplierStockRequest = vmiBatchService.createSupplierRequest(vmiBatchService.flatMapList(stockLeroy), stockEbs);
        logger.info("Saving and publishing ");
        vmiBatchService.saveAndPublish(new LeroyBatchNewItemVMI(supplierStockRequest));
        logger.info("Ending orchestration");
        logger.info("Orchestration finished");
    }


}
