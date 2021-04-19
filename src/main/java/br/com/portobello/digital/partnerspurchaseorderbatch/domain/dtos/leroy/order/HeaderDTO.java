package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order;

import java.math.BigDecimal;

public class HeaderDTO {
    private String orderNumber;
    private String companyCode;
    private String fiscalIDIssuerPlant;
    private String descPaymentKeyTerms;
    private BigDecimal netValue;
    private boolean isCrossDocking;
    private String orderStatus;
    private String orderLastUpdate;
    private boolean isIndicateChangeImpactSupplier;
    private String paymentKeyTerms;
    private String issuerPlant;
    private String documentType;
    private String deliveryDate;
    private String typeShippingFreight;
    private String receiverPlant;
    private String buyerGroupCode;
    private String fiscalID;
    private String orderCreationDate;
    private String typeOperation;
    private BigDecimal totalValue;
    private BigDecimal valueTaxSubstitutionTotal;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getFiscalIDIssuerPlant() {
        return fiscalIDIssuerPlant;
    }

    public void setFiscalIDIssuerPlant(String fiscalIDIssuerPlant) {
        this.fiscalIDIssuerPlant = fiscalIDIssuerPlant;
    }

    public String getDescPaymentKeyTerms() {
        return descPaymentKeyTerms;
    }

    public void setDescPaymentKeyTerms(String descPaymentKeyTerms) {
        this.descPaymentKeyTerms = descPaymentKeyTerms;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public boolean getCrossDocking() {
        return isCrossDocking;
    }

    public void setCrossDocking(boolean crossDocking) {
        isCrossDocking = crossDocking;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderLastUpdate() {
        return orderLastUpdate;
    }

    public void setOrderLastUpdate(String orderLastUpdate) {
        this.orderLastUpdate = orderLastUpdate;
    }

    public boolean getIndicateChangeImpactSupplier() {
        return isIndicateChangeImpactSupplier;
    }

    public void setIndicateChangeImpactSupplier(boolean indicateChangeImpactSupplier) {
        isIndicateChangeImpactSupplier = indicateChangeImpactSupplier;
    }

    public String getPaymentKeyTerms() {
        return paymentKeyTerms;
    }

    public void setPaymentKeyTerms(String paymentKeyTerms) {
        this.paymentKeyTerms = paymentKeyTerms;
    }

    public String getIssuerPlant() {
        return issuerPlant;
    }

    public void setIssuerPlant(String issuerPlant) {
        this.issuerPlant = issuerPlant;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTypeShippingFreight() {
        return typeShippingFreight;
    }

    public void setTypeShippingFreight(String typeShippingFreight) {
        this.typeShippingFreight = typeShippingFreight;
    }

    public String getReceiverPlant() {
        return receiverPlant;
    }

    public void setReceiverPlant(String receiverPlant) {
        this.receiverPlant = receiverPlant;
    }

    public String getBuyerGroupCode() {
        return buyerGroupCode;
    }

    public void setBuyerGroupCode(String buyerGroupCode) {
        this.buyerGroupCode = buyerGroupCode;
    }

    public String getFiscalID() {
        return fiscalID;
    }

    public void setFiscalID(String fiscalID) {
        this.fiscalID = fiscalID;
    }

    public String getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(String orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getValueTaxSubstitutionTotal() {
        return valueTaxSubstitutionTotal;
    }

    public void setValueTaxSubstitutionTotal(BigDecimal valueTaxSubstitutionTotal) {
        this.valueTaxSubstitutionTotal = valueTaxSubstitutionTotal;
    }
}
