package br.com.portobello.digital.partnerspurchaseorderbatch.service.facade;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order.LeroyBatchesInfo;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory.VmiFactory;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.vos.leroy.FilterVo;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.order.LeroyBatchItemRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.order.LeroyBatchesRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.vmi.LeroyBatchItemVMIRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.leroy.LeroyStockLevelService;
import br.com.portobello.digital.partnerspurchaseorderbatch.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Service
public class LeroyBatchFacadeService {

    Logger logger = LoggerFactory.getLogger(LeroyBatchFacadeService.class);
    @Autowired
    private LeroyBatchItemVMIRepository leroyBatchItemVMIRepository;

    @Autowired
    private LeroyBatchesRepository leroyBatchesRepository;

    @Autowired
    private LeroyBatchItemRepository leroyBatchItemRepository;

    @Autowired
    private VmiFactory vmiFactory;

    @Autowired
    private LeroyStockLevelService leroyStockLevelService;

    public void clearDocuments() {
        logger.info("Cleaning Orders documents");
        leroyBatchItemRepository.deleteAll();

    }

    public FilterVo getIntegrationPeriod() {
        LeroyBatchesInfo lastExecutionTime = leroyBatchesRepository.findFirstByLastExecutionIsNotNullOrderByLastExecutionDesc();
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        LocalDateTime initialDateTime = Objects.nonNull(lastExecutionTime) ? lastExecutionTime.getLastExecution() : now;
        return new FilterVo(initialDateTime, now, Constants.LEROY_INITIAL_OFFSET);
    }


    public void clearVMIDocuments() {
        logger.info("Cleaning VMI documents");
        leroyBatchItemVMIRepository.deleteAll();
        leroyBatchItemVMIRepository.deleteAll();
    }

}
