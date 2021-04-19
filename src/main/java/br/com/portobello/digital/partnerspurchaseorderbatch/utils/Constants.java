package br.com.portobello.digital.partnerspurchaseorderbatch.utils;

import java.util.List;

public interface Constants {
    Integer LEROY_LIMIT_ITENS_PER_PAGE = 25;
    Integer LEROY_INITIAL_OFFSET = 0;
    String PUBLISH_PARTNERS_PURCHASE_ORDER_REQUESTED = "publishPartnersPurchaseOrderRequested";
    String PARTNERS_PURCHASE_ORDER_BATCH_OPERATION_ERROR = "publishPartnersPurchaseOrderRequestedError";
    List<Integer> LEROY_ACTIVE_PURCHASE_ORDER_LIST_CODE = List.of(34, 36, 38, 40);
    String LEROY_PAYMENT_KEY_TERM = "Z068";
    String PUBLISH_VMI_REQUESTED = "publishVMIRequested";
    String PARTNERS_VMI_OPERATION_ERROR = "publishVMIRequestedError";
    ;
    String PORTOBELLO_LEROY_FISCAL_ID = "83475913000272";
}
