/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.entities;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc3-cellx
 */
@Entity
@Table(name = "PaymentSchedule")
@NamedQueries({
    @NamedQuery(name = "PaymentSchedule.findAll", query = "SELECT p FROM PaymentSchedule p")})
public class PaymentSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "createdOn")
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    @Size(max = 500)
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "modifiedOn")
    @Temporal(TemporalType.DATE)
    private Date modifiedOn;
    @Size(max = 500)
    @Column(name = "modifiedBy")
    private String modifiedBy;
    @Size(max = 500)
    @Column(name = "createdOnBehalfBy")
    private String createdOnBehalfBy;
    @Size(max = 500)
    @Column(name = "modifiedOnBehalfBy")
    private String modifiedOnBehalfBy;
    @Column(name = "overriddenCreatedOn")
    @Temporal(TemporalType.DATE)
    private Date overriddenCreatedOn;
    @Column(name = "importSequenceNumber")
    private Integer importSequenceNumber;
    @Size(max = 50)
    @Column(name = "ownerIdType")
    private String ownerIdType;
    @Size(max = 50)
    @Column(name = "ownerId")
    private String ownerId;
    @Size(max = 50)
    @Column(name = "owningBusinessUnit")
    private String owningBusinessUnit;
    @Size(max = 50)
    @Column(name = "owningUser")
    private String owningUser;
    @Size(max = 50)
    @Column(name = "owningTeam")
    private String owningTeam;
    @Column(name = "timeZoneRuleVersionNumber")
    private Integer timeZoneRuleVersionNumber;
    @Column(name = "UTCConversionTimeZoneCode")
    private Integer uTCConversionTimeZoneCode;
    @Column(name = "versionNumber")
    private Integer versionNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "guid")
    @GenericGenerator(name = "guid", strategy = "guid")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "paymentScheduleId")
    private String paymentScheduleId;
    @Column(name = "stateCode")
    private Integer stateCode;
    @Size(max = 500)
    @Column(name = "stateCode_display")
    private String stateCodedisplay;
    @Column(name = "statusCode")
    private Integer statusCode;
    @Size(max = 500)
    @Column(name = "statusCode_display")
    private String statusCodedisplay;
    @Size(max = 500)
    @Column(name = "name")
    private String name;
    @Column(name = "firstPaymentDate")
    @Temporal(TemporalType.DATE)
    private Date firstPaymentDate;
    @Column(name = "frequency")
    private Integer frequency;
    @Size(max = 500)
    @Column(name = "frequency_display")
    private String frequencyDisplay;
    @Column(name = "frequencyInterval")
    private Integer frequencyInterval;
    @Column(name = "lastPaymentDate")
    @Temporal(TemporalType.DATE)
    private Date lastPaymentDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nextPaymentAmount")
    private BigDecimal nextPaymentAmount;
    @Size(max = 50)
    @Column(name = "transactionCurrencyId")
    private String transactionCurrencyId;
    @Column(name = "exchangeRate")
    private BigDecimal exchangeRate;
    @Column(name = "nextPaymentAmountBase")
    private BigDecimal nextPaymentAmountBase;
    @Column(name = "nextPaymentDate")
    @Temporal(TemporalType.DATE)
    private Date nextPaymentDate;
    @Column(name = "numberOfPayments")
    private Integer numberOfPayments;
    @Size(max = 50)
    @Column(name = "omtSchedDefaultHardCreditToCustomer")
    private String omtSchedDefaultHardCreditToCustomer;
    @Size(max = 50)
    @Column(name = "paymentScheduleDonorCommitmentId")
    private String paymentScheduleDonorCommitmentId;
    @Size(max = 50)
    @Column(name = "receiptOnAccountId")
    private String receiptOnAccountId;
    @Column(name = "recurringAmount")
    private BigDecimal recurringAmount;
    @Column(name = "recurringamountBase")
    private BigDecimal recurringamountBase;
    @Column(name = "totalAmount")
    private BigDecimal totalAmount;
    @Column(name = "totalamountBase")
    private BigDecimal totalamountBase;


    public PaymentSchedule() {
    }

    public PaymentSchedule(String paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedOnBehalfBy() {
        return createdOnBehalfBy;
    }

    public void setCreatedOnBehalfBy(String createdOnBehalfBy) {
        this.createdOnBehalfBy = createdOnBehalfBy;
    }

    public String getModifiedOnBehalfBy() {
        return modifiedOnBehalfBy;
    }

    public void setModifiedOnBehalfBy(String modifiedOnBehalfBy) {
        this.modifiedOnBehalfBy = modifiedOnBehalfBy;
    }

    public Date getOverriddenCreatedOn() {
        return overriddenCreatedOn;
    }

    public void setOverriddenCreatedOn(Date overriddenCreatedOn) {
        this.overriddenCreatedOn = overriddenCreatedOn;
    }

    public Integer getImportSequenceNumber() {
        return importSequenceNumber;
    }

    public void setImportSequenceNumber(Integer importSequenceNumber) {
        this.importSequenceNumber = importSequenceNumber;
    }

    public String getOwnerIdType() {
        return ownerIdType;
    }

    public void setOwnerIdType(String ownerIdType) {
        this.ownerIdType = ownerIdType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwningBusinessUnit() {
        return owningBusinessUnit;
    }

    public void setOwningBusinessUnit(String owningBusinessUnit) {
        this.owningBusinessUnit = owningBusinessUnit;
    }

    public String getOwningUser() {
        return owningUser;
    }

    public void setOwningUser(String owningUser) {
        this.owningUser = owningUser;
    }

    public String getOwningTeam() {
        return owningTeam;
    }

    public void setOwningTeam(String owningTeam) {
        this.owningTeam = owningTeam;
    }

    public Integer getTimeZoneRuleVersionNumber() {
        return timeZoneRuleVersionNumber;
    }

    public void setTimeZoneRuleVersionNumber(Integer timeZoneRuleVersionNumber) {
        this.timeZoneRuleVersionNumber = timeZoneRuleVersionNumber;
    }

    public Integer getUTCConversionTimeZoneCode() {
        return uTCConversionTimeZoneCode;
    }

    public void setUTCConversionTimeZoneCode(Integer uTCConversionTimeZoneCode) {
        this.uTCConversionTimeZoneCode = uTCConversionTimeZoneCode;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(String paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateCodedisplay() {
        return stateCodedisplay;
    }

    public void setStateCodedisplay(String stateCodedisplay) {
        this.stateCodedisplay = stateCodedisplay;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCodedisplay() {
        return statusCodedisplay;
    }

    public void setStatusCodedisplay(String statusCodedisplay) {
        this.statusCodedisplay = statusCodedisplay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate) {
        this.firstPaymentDate = firstPaymentDate;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getFrequencyDisplay() {
        return frequencyDisplay;
    }

    public void setFrequencyDisplay(String frequencyDisplay) {
        this.frequencyDisplay = frequencyDisplay;
    }

    public Integer getFrequencyInterval() {
        return frequencyInterval;
    }

    public void setFrequencyInterval(Integer frequencyInterval) {
        this.frequencyInterval = frequencyInterval;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public BigDecimal getNextPaymentAmount() {
        return nextPaymentAmount;
    }

    public void setNextPaymentAmount(BigDecimal nextPaymentAmount) {
        this.nextPaymentAmount = nextPaymentAmount;
    }

    public String getTransactionCurrencyId() {
        return transactionCurrencyId;
    }

    public void setTransactionCurrencyId(String transactionCurrencyId) {
        this.transactionCurrencyId = transactionCurrencyId;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getNextPaymentAmountBase() {
        return nextPaymentAmountBase;
    }

    public void setNextPaymentAmountBase(BigDecimal nextPaymentAmountBase) {
        this.nextPaymentAmountBase = nextPaymentAmountBase;
    }

    public Date getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(Date nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public Integer getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(Integer numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public String getOmtSchedDefaultHardCreditToCustomer() {
        return omtSchedDefaultHardCreditToCustomer;
    }

    public void setOmtSchedDefaultHardCreditToCustomer(String omtSchedDefaultHardCreditToCustomer) {
        this.omtSchedDefaultHardCreditToCustomer = omtSchedDefaultHardCreditToCustomer;
    }

    public String getPaymentScheduleDonorCommitmentId() {
        return paymentScheduleDonorCommitmentId;
    }

    public void setPaymentScheduleDonorCommitmentId(String paymentScheduleDonorCommitmentId) {
        this.paymentScheduleDonorCommitmentId = paymentScheduleDonorCommitmentId;
    }

    public String getReceiptOnAccountId() {
        return receiptOnAccountId;
    }

    public void setReceiptOnAccountId(String receiptOnAccountId) {
        this.receiptOnAccountId = receiptOnAccountId;
    }

    public BigDecimal getRecurringAmount() {
        return recurringAmount;
    }

    public void setRecurringAmount(BigDecimal recurringAmount) {
        this.recurringAmount = recurringAmount;
    }

    public BigDecimal getRecurringamountBase() {
        return recurringamountBase;
    }

    public void setRecurringamountBase(BigDecimal recurringamountBase) {
        this.recurringamountBase = recurringamountBase;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalamountBase() {
        return totalamountBase;
    }

    public void setTotalamountBase(BigDecimal totalamountBase) {
        this.totalamountBase = totalamountBase;
    }

//    public List<CreditPlan> getCreditPlanList() {
//        return creditPlanList;
//    }
//
//    public void setCreditPlanList(List<CreditPlan> creditPlanList) {
//        this.creditPlanList = creditPlanList;
//    }
//
//    public List<Transactions> getTransactionsList() {
//        return transactionsList;
//    }
//
//    public void setTransactionsList(List<Transactions> transactionsList) {
//        this.transactionsList = transactionsList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentScheduleId != null ? paymentScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentSchedule)) {
            return false;
        }
        PaymentSchedule other = (PaymentSchedule) object;
        if ((this.paymentScheduleId == null && other.paymentScheduleId != null) || (this.paymentScheduleId != null && !this.paymentScheduleId.equals(other.paymentScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.PaymentSchedule[ paymentScheduleId=" + paymentScheduleId + " ]";
    }
    
}
