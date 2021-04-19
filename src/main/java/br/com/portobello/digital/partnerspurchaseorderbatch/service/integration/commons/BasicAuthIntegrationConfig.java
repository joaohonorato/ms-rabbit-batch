package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class BasicAuthIntegrationConfig {

    @Autowired
    private ConnectionProperties connectionProperties;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(connectionProperties.getGatewayClientId(), connectionProperties.getGatewayClientSecret());
    }
}
