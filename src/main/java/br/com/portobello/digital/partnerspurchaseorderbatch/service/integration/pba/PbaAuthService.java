package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba;


import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.AccessTokenDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.BasicAuthIntegrationConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pbaAuthIntegration", url = "${app.oAuthEnpoint}", configuration = BasicAuthIntegrationConfig.class)
public interface PbaAuthService {

    @PostMapping(headers = {"Content-Type=application/x-www-form-urlencoded"})
    AccessTokenDTO getToken(@RequestBody MultiValueMap<String, String> query);
}
