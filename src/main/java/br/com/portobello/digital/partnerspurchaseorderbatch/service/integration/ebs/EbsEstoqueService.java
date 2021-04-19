package br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.ebs;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.reponse.EstoqueEBSResponseDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.request.EstoqueEBSRequestDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.commons.TokenServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "EbsEstoqueIntegration", url = "${app.basePath}", configuration = TokenServiceConfig.class)
public interface EbsEstoqueService {
    @PostMapping(value = "${app.ebs.estoqueEndpoint}")
    List<EstoqueEBSResponseDTO> getEstoqueInfo(@RequestBody EstoqueEBSRequestDTO requestDTO);

}
