package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.leroy;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductVMIResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.TokenServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "LeroyPVMIIntegration", url = "${app.basePath}", configuration = TokenServiceConfig.class)
public interface LeroyProductVMIService {
    @GetMapping(value = "${app.leroy.productVMI}")
    ProductVMIResponseLeroyDTO getProductsVMI(@PathVariable("id") String id, @RequestParam("_offset") Integer offset, @RequestParam("_limit") Integer limit);
}
