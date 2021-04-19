package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.CustomerPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.TokenServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PbaCustomerIntegration", url = "${app.basePath}", configuration = TokenServiceConfig.class)
public interface PbaCustomerService {
    @GetMapping(value = "${app.pba.customerEndpoint}")
    List<CustomerPbaDTO> getCustomers(@PathVariable("id") Integer id);

}
