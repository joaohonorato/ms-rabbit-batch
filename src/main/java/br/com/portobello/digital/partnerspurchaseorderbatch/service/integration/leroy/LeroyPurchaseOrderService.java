package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.leroy;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order.OrderResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.TokenServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "LeroyPOIntegration", url = "${app.basePath}", configuration = TokenServiceConfig.class)
public interface LeroyPurchaseOrderService {
    @GetMapping(value = "${app.leroy.purchaseOrdersEndpoint}")
    OrderResponseLeroyDTO getPurchaseOrders(@RequestParam("initialOrderCreationDate") String dataInicio, @RequestParam("finalOrderCreationDate") String dataFim, @RequestParam("_offset") Integer offset, @RequestParam("_limit") Integer limit);
}
