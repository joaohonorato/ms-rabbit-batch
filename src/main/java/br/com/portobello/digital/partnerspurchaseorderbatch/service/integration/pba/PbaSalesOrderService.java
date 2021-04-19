package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.SalesOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.TokenServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PbaSOIntegration", url = "${app.basePath}", configuration = TokenServiceConfig.class)
public interface PbaSalesOrderService {
    @GetMapping(value = "${app.pba.salesOrdersEndpoint}")
    List<SalesOrderPbaDTO> getSalesOrders(@PathVariable("id") Long id);

}
