package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionProperties {

    @Value("${app.gatewayClientId}")
    private String gatewayClientId;
    @Value("${app.gatewayClientSecret}")
    private String gatewayClientSecret;


    public String getGatewayClientId() {
        return gatewayClientId;
    }

    public void setGatewayClientId(String gatewayClientId) {
        this.gatewayClientId = gatewayClientId;
    }

    public String getGatewayClientSecret() {
        return gatewayClientSecret;
    }

    public void setGatewayClientSecret(String gatewayClientSecret) {
        this.gatewayClientSecret = gatewayClientSecret;
    }
}
