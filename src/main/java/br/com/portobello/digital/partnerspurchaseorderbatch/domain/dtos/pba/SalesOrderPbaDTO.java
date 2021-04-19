package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba;

import java.util.List;

public class SalesOrderPbaDTO {

    private String id;
    private String transactionNumber;
    private String transactionDate;
    private String projectTypeValue;
    private String projectManagerName;
    private String location;
    private String deliveryType;
    private String customer;
    private String customerType;
    private String shipToName;
    private String shipToAttn;
    private String shipToAddress;
    private String shipToAddress2;
    private String shipToCity;
    private String shipToState;
    private String shipToZip;
    private String shipToPhone;
    private String shipToMobile;
    private String paymentTerms;
    private String priceLevel;
    private String shipmentTerms;
    private String salesRep1;
    private String salesRep2;
    private String primarySRepID;
    private String secondarySRepID;
    private String customerID;
    private String etaDate;
    private String salesTax;
    private String total;
    private String discount;
    private String creditReleaseBy;
    private String creditReleaseOn;
    private String transactionStatus;
    private String jobName;
    private String internalNotes;
    private String printedNotes;
    private String customerPO;
    private String referredBy;
    private String createdOn;
    private String accountingAttn;
    private String fulfillmentPercent;
    private String closedOn;
    private String voidedOn;
    private String voidReason;
    private String requestedShipDate;
    private String endUseSegment;
    private String lot;
    private String subdivision;
    private String closedBy;
    private String arrivalPort;
    private String dischargePort;
    private String departurePort;
    private String containerNumber;
    private String siplStatus;
    private String vessel;
    private String freightForwarder;
    private String siplInvoiceDate;
    private String siplDueDate;
    private String siplShipDate;
    private String subTransactions;
    private List<ProductPbaDTO> soProducts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getProjectTypeValue() {
        return projectTypeValue;
    }

    public void setProjectTypeValue(String projectTypeValue) {
        this.projectTypeValue = projectTypeValue;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getShipToName() {
        return shipToName;
    }

    public void setShipToName(String shipToName) {
        this.shipToName = shipToName;
    }

    public String getShipToAttn() {
        return shipToAttn;
    }

    public void setShipToAttn(String shipToAttn) {
        this.shipToAttn = shipToAttn;
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

    public String getShipToPhone() {
        return shipToPhone;
    }

    public void setShipToPhone(String shipToPhone) {
        this.shipToPhone = shipToPhone;
    }

    public String getShipToMobile() {
        return shipToMobile;
    }

    public void setShipToMobile(String shipToMobile) {
        this.shipToMobile = shipToMobile;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    public String getShipmentTerms() {
        return shipmentTerms;
    }

    public void setShipmentTerms(String shipmentTerms) {
        this.shipmentTerms = shipmentTerms;
    }

    public String getSalesRep1() {
        return salesRep1;
    }

    public void setSalesRep1(String salesRep1) {
        this.salesRep1 = salesRep1;
    }

    public String getSalesRep2() {
        return salesRep2;
    }

    public void setSalesRep2(String salesRep2) {
        this.salesRep2 = salesRep2;
    }

    public String getPrimarySRepID() {
        return primarySRepID;
    }

    public void setPrimarySRepID(String primarySRepID) {
        this.primarySRepID = primarySRepID;
    }

    public String getSecondarySRepID() {
        return secondarySRepID;
    }

    public void setSecondarySRepID(String secondarySRepID) {
        this.secondarySRepID = secondarySRepID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getEtaDate() {
        return etaDate;
    }

    public void setEtaDate(String etaDate) {
        this.etaDate = etaDate;
    }

    public String getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCreditReleaseBy() {
        return creditReleaseBy;
    }

    public void setCreditReleaseBy(String creditReleaseBy) {
        this.creditReleaseBy = creditReleaseBy;
    }

    public String getCreditReleaseOn() {
        return creditReleaseOn;
    }

    public void setCreditReleaseOn(String creditReleaseOn) {
        this.creditReleaseOn = creditReleaseOn;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public String getCustomerPO() {
        return customerPO;
    }

    public void setCustomerPO(String customerPO) {
        this.customerPO = customerPO;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getAccountingAttn() {
        return accountingAttn;
    }

    public void setAccountingAttn(String accountingAttn) {
        this.accountingAttn = accountingAttn;
    }

    public String getFulfillmentPercent() {
        return fulfillmentPercent;
    }

    public void setFulfillmentPercent(String fulfillmentPercent) {
        this.fulfillmentPercent = fulfillmentPercent;
    }

    public String getClosedOn() {
        return closedOn;
    }

    public void setClosedOn(String closedOn) {
        this.closedOn = closedOn;
    }

    public String getVoidedOn() {
        return voidedOn;
    }

    public void setVoidedOn(String voidedOn) {
        this.voidedOn = voidedOn;
    }

    public String getVoidReason() {
        return voidReason;
    }

    public void setVoidReason(String voidReason) {
        this.voidReason = voidReason;
    }

    public String getRequestedShipDate() {
        return requestedShipDate;
    }

    public void setRequestedShipDate(String requestedShipDate) {
        this.requestedShipDate = requestedShipDate;
    }

    public String getEndUseSegment() {
        return endUseSegment;
    }

    public void setEndUseSegment(String endUseSegment) {
        this.endUseSegment = endUseSegment;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
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

    public String getSiplStatus() {
        return siplStatus;
    }

    public void setSiplStatus(String siplStatus) {
        this.siplStatus = siplStatus;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getFreightForwarder() {
        return freightForwarder;
    }

    public void setFreightForwarder(String freightForwarder) {
        this.freightForwarder = freightForwarder;
    }

    public String getSiplInvoiceDate() {
        return siplInvoiceDate;
    }

    public void setSiplInvoiceDate(String siplInvoiceDate) {
        this.siplInvoiceDate = siplInvoiceDate;
    }

    public String getSiplDueDate() {
        return siplDueDate;
    }

    public void setSiplDueDate(String siplDueDate) {
        this.siplDueDate = siplDueDate;
    }

    public String getSiplShipDate() {
        return siplShipDate;
    }

    public void setSiplShipDate(String siplShipDate) {
        this.siplShipDate = siplShipDate;
    }

    public String getSubTransactions() {
        return subTransactions;
    }

    public void setSubTransactions(String subTransactions) {
        this.subTransactions = subTransactions;
    }

    public List<ProductPbaDTO> getSoProducts() {
        return soProducts;
    }

    public void setSoProducts(List<ProductPbaDTO> soProducts) {
        this.soProducts = soProducts;
    }
}
