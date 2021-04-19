package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.leroy;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductVMIResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.TokenServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "LeroyVMIIntegration", url = "${app.basePath}", configuration = TokenServiceConfig.class)
public interface LeroyVMIService {
    @GetMapping(value = "${app.leroy.vmi.vmiEndpoint}")
    ProductVMIResponseLeroyDTO getVMI(@PathVariable("id") String dataInicio, @RequestParam("_offset") Integer offset, @RequestParam("_limit") Integer limit);

}
