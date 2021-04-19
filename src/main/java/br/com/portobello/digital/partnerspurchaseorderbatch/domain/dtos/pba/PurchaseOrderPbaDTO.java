package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrderPbaDTO {
    @NotNull
    private Long id;
    private String transactionNumber;
    private String transactionDate;
    private String supplierSO;
    private Long supplierID;
    private String transactionStatus;
    private String deliveryType;
    private String location;
    private String shipToName;
    private String shipToAddress;
    private String shipToAddress2;
    private String shipToAttn;
    private String shipToCity;
    private String shipToState;
    private String shipToZip;
    private String shipToPhone1;
    private String shipToFax;
    private String paymentTerms;
    private String shipmentTerms;
    private BigDecimal total;
    private String arrivalPort;
    private String dischargePort;
    private String departurePort;
    private String containerNumber;
    private String vessel;
    private String requestedShipDate;
    private String freightForwarder;
    private String saleOrderReference;
    private String jobName;
    private Long saleorderID;
    private String customerReferenceName;
    private Integer customerID;
    private String internalNotes;
    private String printedNotes;
    private String fulfillmentPercent;
    private String shipToLocationID;
    private Long locationID;
    private List<ProductPbaDTO> poProducts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSupplierSO() {
        return supplierSO;
    }

    public void setSupplierSO(String supplierSO) {
        this.supplierSO = supplierSO;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShipToName() {
        return shipToName;
    }

    public void setShipToName(String shipToName) {
        this.shipToName = shipToName;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public String getShipToAddress2() {
        return shipToAddress2;
    }

    public void setShipToAddress2(String shipToAddress2) {
        this.shipToAddress2 = shipToAddress2;
    }

    public String getShipToAttn() {
        return shipToAttn;
    }

    public void setShipToAttn(String shipToAttn) {
        this.shipToAttn = shipToAttn;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public void setShipToCity(String shipToCity) {
        this.shipToCity = shipToCity;
    }

    public String getShipToState() {
        return shipToState;
    }

    public void setShipToState(String shipToState) {
        this.shipToState = shipToState;
    }

    public String getShipToZip() {
        return shipToZip;
    }

    public void setShipToZip(String shipToZip) {
        this.shipToZip = shipToZip;
    }

    public String getShipToPhone1() {
        return shipToPhone1;
    }

    public void setShipToPhone1(String shipToPhone1) {
        this.shipToPhone1 = shipToPhone1;
    }

    public String getShipToFax() {
        return shipToFax;
    }

    public void setShipToFax(String shipToFax) {
        this.shipToFax = shipToFax;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getShipmentTerms() {
        return shipmentTerms;
    }

    public void setShipmentTerms(String shipmentTerms) {
        this.shipmentTerms = shipmentTerms;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public String getDischargePort() {
        return dischargePort;
    }

    public void setDischargePort(String dischargePort) {
        this.dischargePort = dischargePort;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(String departurePort) {
        this.departurePort = departurePort;
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getRequestedShipDate() {
        return requestedShipDate;
    }

    public void setRequestedShipDate(String requestedShipDate) {
        this.requestedShipDate = requestedShipDate;
    }

    public String getFreightForwarder() {
        return freightForwarder;
    }

    public void setFreightForwarder(String freightForwarder) {
        this.freightForwarder = freightForwarder;
    }

    public String getSaleOrderReference() {
        return saleOrderReference;
    }

    public void setSaleOrderReference(String saleOrderReference) {
        this.saleOrderReference = saleOrderReference;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Long getSaleorderID() {
        return saleorderID;
    }

    public void setSaleorderID(Long saleorderID) {
        this.saleorderID = saleorderID;
    }

    public String getCustomerReferenceName() {
        return customerReferenceName;
    }

    public void setCustomerReferenceName(String customerReferenceName) {
        this.customerReferenceName = customerReferenceName;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    public String getPrintedNotes() {
        return printedNotes;
    }

    public void setPrintedNotes(String printedNotes) {
        this.printedNotes = printedNotes;
    }

    public String getFulfillmentPercent() {
        return fulfillmentPercent;
    }

    public void setFulfillmentPercent(String fulfillmentPercent) {
        this.fulfillmentPercent = fulfillmentPercent;
    }

    public String getShipToLocationID() {
        return shipToLocationID;
    }

    public void setShipToLocationID(String shipToLocationID) {
        this.shipToLocationID = shipToLocationID;
    }

    public Long getLocationID() {
        return locationID;
    }

    public void setLocationID(Long locationID) {
        this.locationID = locationID;
    }

    public List<ProductPbaDTO> getPoProducts() {
        return poProducts;
    }

    public void setPoProducts(List<ProductPbaDTO> poProducts) {
        this.poProducts = poProducts;
    }
}
