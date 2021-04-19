package br.com.portobello.digital.partnerspurchaseorderbatch.schedulers.pba;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.AccessTokenDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.broker.PartnersPurchasePortOutbound;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.orchestration.PbaPurchaseOrderOrchestrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PbaOrderBatchScheduler {

    Logger logger = LoggerFactory.getLogger(PbaOrderBatchScheduler.class);

    @Autowired
    private PbaPurchaseOrderOrchestrator pbaOrderOrchestrator;

    @Autowired
    private PartnersPurchasePortOutbound outbound;

    @Value("${app.pba.order.enabled:true}")
    private boolean isEnabled;

    private AccessTokenDTO token;


    @Scheduled(fixedDelayString = "${fixedDelay.pba.in.milliseconds}")
    public void scheduler() {
        if (isEnabled) {
            try {
                pbaOrderOrchestrator.start();
            } catch (Exception e) {
                logger.info("[PBA - INTEGRATION FAIL] Localized Message : {} , Message : {}", e.getLocalizedMessage(), e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
