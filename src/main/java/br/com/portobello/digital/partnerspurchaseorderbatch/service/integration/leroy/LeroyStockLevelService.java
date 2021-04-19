package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.leroy;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductVMIResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierStockRequestDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.TokenServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "LeroyStockLevelIntegration", url = "${app.basePath}", configuration = TokenServiceConfig.class)
public interface LeroyStockLevelService {
    @GetMapping(value = "${app.leroy.vmi.productVMI}")
    ProductVMIResponseLeroyDTO getProductsVMI(@PathVariable("id") String id, @RequestParam("_offset") Integer offset, @RequestParam("_limit") Integer limit);
}
