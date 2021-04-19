package br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.EntregaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class EntregaFactory {
    Logger logger = LoggerFactory.getLogger(EntregaFactory.class);

    public EntregaDTO createEntregaDTO(PurchaseOrderPbaDTO purchaseOrderPbaDTO) {
        var entregaDTO = new EntregaDTO();
        entregaDTO.setDescricaoContato(purchaseOrderPbaDTO.getShipToAttn());
        String shipToPhone1 = purchaseOrderPbaDTO.getShipToPhone1();
        try {
            if (ObjectUtils.isEmpty(shipToPhone1)) {
                entregaDTO.setNumeroTelefoneContato(null);
            } else if (shipToPhone1 != null && shipToPhone1.contains("-")) {
                entregaDTO.setNumeroTelefoneContato(Integer.parseInt(shipToPhone1.replace("-", "").substring(0, shipToPhone1.length() - 1)));
            } else {
                entregaDTO.setNumeroTelefoneContato(Integer.parseInt(shipToPhone1));
            }
        } catch (NumberFormatException e) {
            logger.info("Could not convert shipToPhone1 to a valid number : {}", shipToPhone1);
        }
        return entregaDTO;
    }
}
