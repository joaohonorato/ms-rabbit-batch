package br.com.portobello.digital.partnerspurchaseorderbatch.schedulers.leroy;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.AccessTokenDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.broker.PartnersPurchasePortOutbound;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.orchestration.LeroyPurchaseOrchestrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LeroyBatchScheduler {

    Logger logger = LoggerFactory.getLogger(LeroyBatchScheduler.class);
    @Autowired
    private LeroyPurchaseOrchestrator leroyPurchaseOrchestrator;

    @Autowired
    private PartnersPurchasePortOutbound outbound;

    @Value("${app.leroy.order.enabled:true}")
    private boolean isEnabled;

    private AccessTokenDTO token;


    @Scheduled(fixedDelayString = "${fixedDelay.leroy.in.milliseconds}")
    public void scheduler() {
        if (isEnabled) {
            try {
                leroyPurchaseOrchestrator.start();
            } catch (Exception e) {
                logger.info("[LEROY ORDER - INTEGRATION FAIL] - Localized Message : {} , Message : {}", e.getLocalizedMessage(), e.getMessage());
            }
        }
    }
}
