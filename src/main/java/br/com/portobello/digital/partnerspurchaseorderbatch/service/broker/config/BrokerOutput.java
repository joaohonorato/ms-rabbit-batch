package br.com.portobello.digital.partnerspurchaseorderbatch.service.broker.config;

import br.com.portobello.digital.partnerspurchaseorderbatch.utils.Constants;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface BrokerOutput {

    @Output(Constants.PUBLISH_PARTNERS_PURCHASE_ORDER_REQUESTED)
    SubscribableChannel publishPartnersPurchaseOrderRequested();

    @Output(Constants.PARTNERS_PURCHASE_ORDER_BATCH_OPERATION_ERROR)
    SubscribableChannel publishPartnersPurchaseOrderRequestedError();


    @Output(Constants.PUBLISH_VMI_REQUESTED)
    SubscribableChannel publishVMIRequested();

    @Output(Constants.PARTNERS_VMI_OPERATION_ERROR)
    SubscribableChannel publishVMIRequestedError();


}
