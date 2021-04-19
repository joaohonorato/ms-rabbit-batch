package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order;

import java.math.BigDecimal;

public class ItemLeroyDTO {
    private BigDecimal valueTaxSubstitutionTotal;
    private String productSupplierCode;
    private String productId;
    private BigDecimal totalPrice;
    private BigDecimal netPriceUnit;
    private String orderItem;
    private BigDecimal totalPriceUnit;
    private BigDecimal netPrice;
    private String productName;
    private BigDecimal productQuantity;
    private String orderItemStatus;
    private String productNCMId;
    private String productUnitMeasure;
    private String productEAN;

    public BigDecimal getValueTaxSubstitutionTotal() {
        return valueTaxSubstitutionTotal;
    }

    public void setValueTaxSubstitutionTotal(BigDecimal valueTaxSubstitutionTotal) {
        this.valueTaxSubstitutionTotal = valueTaxSubstitutionTotal;
    }

    public String getProductSupplierCode() {
        return productSupplierCode;
    }

    public void setProductSupplierCode(String productSupplierCode) {
        this.productSupplierCode = productSupplierCode;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getNetPriceUnit() {
        return netPriceUnit;
    }

    public void setNetPriceUnit(BigDecimal netPriceUnit) {
        this.netPriceUnit = netPriceUnit;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public BigDecimal getTotalPriceUnit() {
        return totalPriceUnit;
    }

    public void setTotalPriceUnit(BigDecimal totalPriceUnit) {
        this.totalPriceUnit = totalPriceUnit;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(BigDecimal productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(String orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public String getProductNCMId() {
        return productNCMId;
    }

    public void setProductNCMId(String productNCMId) {
        this.productNCMId = productNCMId;
    }

    public String getProductUnitMeasure() {
        return productUnitMeasure;
    }

    public void setProductUnitMeasure(String productUnitMeasure) {
        this.productUnitMeasure = productUnitMeasure;
    }

    public String getProductEAN() {
        return productEAN;
    }

    public void setProductEAN(String productEAN) {
        this.productEAN = productEAN;
    }
}
