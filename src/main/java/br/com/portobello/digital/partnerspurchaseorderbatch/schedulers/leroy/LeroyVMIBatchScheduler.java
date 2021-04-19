package br.com.portobello.digital.partnerspurchaseorderbatch.schedulers.leroy;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.AccessTokenDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.broker.PartnersPurchasePortOutbound;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.orchestration.LeroyVMIOrchestrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LeroyVMIBatchScheduler {

    Logger logger = LoggerFactory.getLogger(LeroyVMIBatchScheduler.class);

    @Autowired
    private LeroyVMIOrchestrator leroyVMIOrchestrator;

    @Autowired
    private PartnersPurchasePortOutbound outbound;

    @Value("${app.leroy.vmi.enabled:true}")
    private boolean isEnabled;

    private AccessTokenDTO token;


    @Scheduled(fixedDelayString = "${fixedDelay.vmin.in.milliseconds}")
    public void scheduler() {
        if (isEnabled) {
            try {
                leroyVMIOrchestrator.start();
            } catch (Exception e) {
                logger.info("[LEROY VMI - INTEGRATION FAIL] Localized Message : {} , Message : {}", e.getLocalizedMessage(), e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
