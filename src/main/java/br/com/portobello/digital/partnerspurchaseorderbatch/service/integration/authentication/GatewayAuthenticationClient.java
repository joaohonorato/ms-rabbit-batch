package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.authentication;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.AccessTokenDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.BasicAuthIntegrationConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;


@FeignClient(name = "oauthGatewayApi", url = "${app.sensedia.baseUrl}", path = "/oauth", configuration = BasicAuthIntegrationConfig.class)
public interface GatewayAuthenticationClient {


    @PostMapping(value = "/access-token", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    AccessTokenDTO getAccessToken(@RequestBody MultiValueMap<String, String> innerBody);
}
