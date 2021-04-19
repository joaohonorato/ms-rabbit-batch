package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI;

import java.math.BigDecimal;

public class ProductLeroyDTO {

    private String store;
    private String supplierFiscalId;
    private String subrangeId;
    private String productId;
    private String productEAN;
    private Boolean isControlledByBatch;
    private String supplierProductId;
    private BigDecimal minSalesQuantity;
    private String supplierSalesUnitMeasure;
    private String receiverFiscalId;
    private String purchaseDistribuitionProfile;
    private String processBillingType;
    private String dateUpdateVMI;
    private String timeUpdateVMI;
    private String userVMI;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getSupplierFiscalId() {
        return supplierFiscalId;
    }

    public void setSupplierFiscalId(String supplierFiscalId) {
        this.supplierFiscalId = supplierFiscalId;
    }

    public String getSubrangeId() {
        return subrangeId;
    }

    public void setSubrangeId(String subrangeId) {
        this.subrangeId = subrangeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductEAN() {
        return productEAN;
    }

    public void setProductEAN(String productEAN) {
        this.productEAN = productEAN;
    }

    public Boolean getControlledByBatch() {
        return isControlledByBatch;
    }

    public void setControlledByBatch(Boolean controlledByBatch) {
        isControlledByBatch = controlledByBatch;
    }

    public String getSupplierProductId() {
        return supplierProductId;
    }

    public void setSupplierProductId(String supplierProductId) {
        this.supplierProductId = supplierProductId;
    }

    public BigDecimal getMinSalesQuantity() {
        return minSalesQuantity;
    }

    public void setMinSalesQuantity(BigDecimal minSalesQuantity) {
        this.minSalesQuantity = minSalesQuantity;
    }

    public String getSupplierSalesUnitMeasure() {
        return supplierSalesUnitMeasure;
    }

    public void setSupplierSalesUnitMeasure(String supplierSalesUnitMeasure) {
        this.supplierSalesUnitMeasure = supplierSalesUnitMeasure;
    }

    public String getReceiverFiscalId() {
        return receiverFiscalId;
    }

    public void setReceiverFiscalId(String receiverFiscalId) {
        this.receiverFiscalId = receiverFiscalId;
    }

    public String getPurchaseDistribuitionProfile() {
        return purchaseDistribuitionProfile;
    }

    public void setPurchaseDistribuitionProfile(String purchaseDistribuitionProfile) {
        this.purchaseDistribuitionProfile = purchaseDistribuitionProfile;
    }

    public String getProcessBillingType() {
        return processBillingType;
    }

    public void setProcessBillingType(String processBillingType) {
        this.processBillingType = processBillingType;
    }

    public String getDateUpdateVMI() {
        return dateUpdateVMI;
    }

    public void setDateUpdateVMI(String dateUpdateVMI) {
        this.dateUpdateVMI = dateUpdateVMI;
    }

    public String getTimeUpdateVMI() {
        return timeUpdateVMI;
    }

    public void setTimeUpdateVMI(String timeUpdateVMI) {
        this.timeUpdateVMI = timeUpdateVMI;
    }

    public String getUserVMI() {
        return userVMI;
    }

    public void setUserVMI(String userVMI) {
        this.userVMI = userVMI;
    }
}
