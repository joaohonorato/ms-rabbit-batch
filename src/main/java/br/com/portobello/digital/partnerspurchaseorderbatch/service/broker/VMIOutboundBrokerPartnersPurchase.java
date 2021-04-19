package br.com.portobello.digital.partnerspurchaseorderbatch.service.broker;

import br.com.portobello.digital.commons.broker.GenericBrokerOutput;
import br.com.portobello.digital.commons.exceptions.ErrorDetail;
import br.com.portobello.digital.commons.exceptions.ErrorPayloadEvent;
import br.com.portobello.digital.commons.headers.DefaultHeader;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitOperationErrorEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.commons.EventPayload;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.broker.config.BrokerOutput;
import br.com.portobello.digital.partnerspurchaseorderbatch.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@EnableBinding({BrokerOutput.class})
public class VMIOutboundBrokerPartnersPurchase<T extends EventPayload> extends GenericBrokerOutput implements VMIPortOutbound {

    private final BrokerOutput output;
    private Logger logger = LoggerFactory.getLogger(VMIOutboundBrokerPartnersPurchase.class);

    public VMIOutboundBrokerPartnersPurchase(BrokerOutput output) {
        this.output = output;
    }

    @Override
    protected Object getPortOutbound() {
        return output;
    }

    private Map<String, Object> getHeaders() {

        return new DefaultHeader().appId(appId)
                .toMap();
    }

    @Override
    public void sendMessageVMIRequested(RabbitEvent event) {
        logger.info("Send message VMI_REQUESTED. Id: {}", event.getPayload().getPayloadId());
        buildSendBusinessMessage(
                output.publishVMIRequested(),
                event.getPayload(),
                event.getPayload().getPayloadId(),
                Constants.PUBLISH_PARTNERS_PURCHASE_ORDER_REQUESTED,
                this.getHeaders()
        );
    }


    @Override
    public void sendMessageVMIOperationError(RabbitOperationErrorEvent event) {
        buildSendBusinessMessage(
                output.publishVMIRequestedError(),
                new ErrorPayloadEvent<>("partners-purchase-order-batch  VMI integration error").addErros(new ErrorDetail(event.getHttpStatus(), event.getErrorMessage())),
                event.getLocalizedMessage(), Constants.PARTNERS_PURCHASE_ORDER_BATCH_OPERATION_ERROR,
                this.getHeaders()
        );
    }
}
