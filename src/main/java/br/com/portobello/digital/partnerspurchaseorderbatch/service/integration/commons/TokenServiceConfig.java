package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.AccessTokenDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.authentication.GatewayAuthenticationClient;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.Objects;

public class TokenServiceConfig {

    private static final Integer SAFE_MARGIN = 1;

    @Autowired
    private ConnectionProperties connectionProperties;

    @Autowired
    private GatewayAuthenticationClient authentication;

    private AccessTokenDTO token;

    private LocalDateTime lastAuthentication;

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return requestTemplate -> {
            if (Objects.isNull(token) || isTokenExpired()) {
                MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
                map.add("grant_type", "client_credentials");

                this.token = authentication.getAccessToken(map);
                lastAuthentication = LocalDateTime.now();
            }
            requestTemplate.header("client_id", connectionProperties.getGatewayClientId());
            requestTemplate.header("access_token", this.token.getAccessToken());
        };
    }

    private boolean isTokenExpired() {
        return LocalDateTime.now().minusMinutes(token.getExpiresIn() / 60 - SAFE_MARGIN).isAfter(lastAuthentication);
    }
}
