package br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order.OrderLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.ClienteDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.CountryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ClienteFactory {
    Logger logger = LoggerFactory.getLogger(ClienteFactory.class);

    public ClienteDTO createClienteDTO(PurchaseOrderPbaDTO purchaseOrderPbaDTO) {
        var clienteDTO = new ClienteDTO();
        clienteDTO.setCustomName(purchaseOrderPbaDTO.getShipToName());
        clienteDTO.setCustomZipCode(purchaseOrderPbaDTO.getShipToZip());
        clienteDTO.setCustomAddress1(purchaseOrderPbaDTO.getShipToAddress());
        try {
            clienteDTO.setCustomAddress2(purchaseOrderPbaDTO.getShipToAddress2() == null ? null : Integer.parseInt(purchaseOrderPbaDTO.getShipToAddress2()));
        } catch (NumberFormatException e) {
            clienteDTO.setCustomAddress2(null);
            logger.info("Could not convert address2 to a valid number, {}", purchaseOrderPbaDTO.getShipToAddress2());
        }
        clienteDTO.setCustomCity(purchaseOrderPbaDTO.getShipToCity());
        clienteDTO.setCustomState(purchaseOrderPbaDTO.getShipToState());
        clienteDTO.setCustomCountry(CountryType.USA.name());
        clienteDTO.setCustomPhoneNumber(purchaseOrderPbaDTO.getShipToPhone1());
        clienteDTO.setShippingInstructions(String.format("%s %s: %s", purchaseOrderPbaDTO.getShipToAttn(), "phone Number", purchaseOrderPbaDTO.getShipToPhone1()));
        return clienteDTO;
    }

    public ClienteDTO createClienteDTO(OrderLeroyDTO orderLeroyDTO) {
        var clienteDTO = new ClienteDTO();
        clienteDTO.setSoldToFiscalId(orderLeroyDTO.getHeader().getFiscalIDIssuerPlant());
        return clienteDTO;
    }
}
