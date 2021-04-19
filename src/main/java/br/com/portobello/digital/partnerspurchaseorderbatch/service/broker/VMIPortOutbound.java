package br.com.portobello.digital.partnerspurchaseorderbatch.service.broker;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitOperationErrorEvent;

public interface VMIPortOutbound {

    void sendMessageVMIRequested(RabbitEvent event);

    void sendMessageVMIOperationError(RabbitOperationErrorEvent vmiErrorEvent);

}
