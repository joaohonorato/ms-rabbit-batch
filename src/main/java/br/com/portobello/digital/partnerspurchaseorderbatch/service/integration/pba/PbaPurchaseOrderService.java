package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.TokenServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "PbaPOIntegration", url = "${app.basePath}", configuration = TokenServiceConfig.class)
public interface PbaPurchaseOrderService {
    @GetMapping(value = "${app.pba.purchaseOrdersEndpoint}")
    List<PurchaseOrderPbaDTO> getPurchaseOrders(@RequestParam("transactionDate") String dataInicio, @RequestParam("supplierId") String supplierID);

}
