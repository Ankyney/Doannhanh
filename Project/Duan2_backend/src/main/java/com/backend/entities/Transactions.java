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
 * @author pc3-cellx
 */
@Entity
@Table(name = "Transactions")
@NamedQueries({
        @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")})
public class Transactions implements Serializable {

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
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "guid")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transactionId")
    private String transactionId;
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
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @Size(max = 2000)
    @Column(name = "adjustmentComment")
    private String adjustmentComment;
    @Column(name = "adjustmentReason")
    private Integer adjustmentReason;
    @Size(max = 500)
    @Column(name = "adjustmentReason_display")
    private String adjustmentReasondisplay;
    @Column(name = "adjustmentType")
    private Integer adjustmentType;
    @Size(max = 500)
    @Column(name = "adjustmentType_display")
    private String adjustmentTypedisplay;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Size(max = 50)
    @Column(name = "transactionCurrencyId")
    private String transactionCurrencyId;
    @Column(name = "exchangeRate")
    private BigDecimal exchangeRate;
    @Column(name = "amountBase")
    private BigDecimal amountBase;
    @Column(name = "anonymity")
    private Integer anonymity;
    @Size(max = 500)
    @Column(name = "anonymity_display")
    private String anonymityDisplay;
    @Column(name = "bookDate")
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    @Size(max = 500)
    @Column(name = "dataEntryReference")
    private String dataEntryReference;
    @Column(name = "dataEntrySource")
    private Integer dataEntrySource;
    @Size(max = 500)
    @Column(name = "dataEntrySource_display")
    private String dataEntrySourcedisplay;
    @Size(max = 50)
    @Column(name = "effectiveCampaignId")
    private String effectiveCampaignId;
    @Size(max = 500)
    @Column(name = "effectiveSourceCode")
    private String effectiveSourceCode;
    @Column(name = "exchangeRateDate")
    @Temporal(TemporalType.DATE)
    private Date exchangeRateDate;
    @Column(name = "isAdjusted")
    private Short isAdjusted;
    @Size(max = 50)
    @Column(name = "originalTxnAdjustedId")
    private String originalTxnAdjustedId;
    @Size(max = 50)
    @Column(name = "originatingCampaignId")
    private String originatingCampaignId;
    @Size(max = 500)
    @Column(name = "originatingSourceCode")
    private String originatingSourceCode;
    @Column(name = "postedDate")
    @Temporal(TemporalType.DATE)
    private Date postedDate;
    @Column(name = "receivedDate")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    @Size(max = 50)
    @Column(name = "transactionPaymentMethodId")
    private String transactionPaymentMethodId;
    @Column(name = "currencyValueDate")
    @Temporal(TemporalType.DATE)
    private Date currencyValueDate;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "disbursementChannelId")
    private String disbursementChannelId;
    @Size(max = 50)
    @Column(name = "financeTypeId")
    private String financeTypeId;
    @Size(max = 50)
    @Column(name = "flowTypeId")
    private String flowTypeId;
    @Column(name = "humanitarian")
    private Short humanitarian;
    @Size(max = 100)
    @Column(name = "providerActivityIdentifier")
    private String providerActivityIdentifier;
    @Size(max = 50)
    @Column(name = "providerOrganizationId")
    private String providerOrganizationId;
    @Size(max = 100)
    @Column(name = "recipientActivityIdentifier")
    private String recipientActivityIdentifier;
    @Size(max = 2000)
    @Column(name = "recipientCountryDescription")
    private String recipientCountryDescription;
    @Size(max = 50)
    @Column(name = "recipientCountryId")
    private String recipientCountryId;
    @Size(max = 50)
    @Column(name = "recipientOrganizationId")
    private String recipientOrganizationId;
    @Size(max = 2000)
    @Column(name = "recipientRegionDescription")
    private String recipientRegionDescription;
    @Size(max = 50)
    @Column(name = "recipientRegionId")
    private String recipientRegionId;
    @Size(max = 50)
    @Column(name = "tiedStatusId")
    private String tiedStatusId;

    @JoinColumn(name = "transactionReceiptOnAccountId", referencedColumnName = "accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account transactionReceiptOnAccountId;
    @JoinColumn(name = "transactionPaymentScheduleId", referencedColumnName = "paymentScheduleId")
    @ManyToOne(fetch = FetchType.LAZY)
    private PaymentSchedule transactionPaymentScheduleId;


    public Transactions() {
    }

    public Transactions(String transactionId) {
        this.transactionId = transactionId;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    public String getAdjustmentComment() {
        return adjustmentComment;
    }

    public void setAdjustmentComment(String adjustmentComment) {
        this.adjustmentComment = adjustmentComment;
    }

    public Integer getAdjustmentReason() {
        return adjustmentReason;
    }

    public void setAdjustmentReason(Integer adjustmentReason) {
        this.adjustmentReason = adjustmentReason;
    }

    public String getAdjustmentReasondisplay() {
        return adjustmentReasondisplay;
    }

    public void setAdjustmentReasondisplay(String adjustmentReasondisplay) {
        this.adjustmentReasondisplay = adjustmentReasondisplay;
    }

    public Integer getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(Integer adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public String getAdjustmentTypedisplay() {
        return adjustmentTypedisplay;
    }

    public void setAdjustmentTypedisplay(String adjustmentTypedisplay) {
        this.adjustmentTypedisplay = adjustmentTypedisplay;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public BigDecimal getAmountBase() {
        return amountBase;
    }

    public void setAmountBase(BigDecimal amountBase) {
        this.amountBase = amountBase;
    }

    public Integer getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(Integer anonymity) {
        this.anonymity = anonymity;
    }

    public String getAnonymityDisplay() {
        return anonymityDisplay;
    }

    public void setAnonymityDisplay(String anonymityDisplay) {
        this.anonymityDisplay = anonymityDisplay;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getDataEntryReference() {
        return dataEntryReference;
    }

    public void setDataEntryReference(String dataEntryReference) {
        this.dataEntryReference = dataEntryReference;
    }

    public Integer getDataEntrySource() {
        return dataEntrySource;
    }

    public void setDataEntrySource(Integer dataEntrySource) {
        this.dataEntrySource = dataEntrySource;
    }

    public String getDataEntrySourcedisplay() {
        return dataEntrySourcedisplay;
    }

    public void setDataEntrySourcedisplay(String dataEntrySourcedisplay) {
        this.dataEntrySourcedisplay = dataEntrySourcedisplay;
    }

    public String getEffectiveCampaignId() {
        return effectiveCampaignId;
    }

    public void setEffectiveCampaignId(String effectiveCampaignId) {
        this.effectiveCampaignId = effectiveCampaignId;
    }

    public String getEffectiveSourceCode() {
        return effectiveSourceCode;
    }

    public void setEffectiveSourceCode(String effectiveSourceCode) {
        this.effectiveSourceCode = effectiveSourceCode;
    }

    public Date getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(Date exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public Short getIsAdjusted() {
        return isAdjusted;
    }

    public void setIsAdjusted(Short isAdjusted) {
        this.isAdjusted = isAdjusted;
    }

    public String getOriginalTxnAdjustedId() {
        return originalTxnAdjustedId;
    }

    public void setOriginalTxnAdjustedId(String originalTxnAdjustedId) {
        this.originalTxnAdjustedId = originalTxnAdjustedId;
    }

    public String getOriginatingCampaignId() {
        return originatingCampaignId;
    }

    public void setOriginatingCampaignId(String originatingCampaignId) {
        this.originatingCampaignId = originatingCampaignId;
    }

    public String getOriginatingSourceCode() {
        return originatingSourceCode;
    }

    public void setOriginatingSourceCode(String originatingSourceCode) {
        this.originatingSourceCode = originatingSourceCode;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getTransactionPaymentMethodId() {
        return transactionPaymentMethodId;
    }

    public void setTransactionPaymentMethodId(String transactionPaymentMethodId) {
        this.transactionPaymentMethodId = transactionPaymentMethodId;
    }

    public Date getCurrencyValueDate() {
        return currencyValueDate;
    }

    public void setCurrencyValueDate(Date currencyValueDate) {
        this.currencyValueDate = currencyValueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisbursementChannelId() {
        return disbursementChannelId;
    }

    public void setDisbursementChannelId(String disbursementChannelId) {
        this.disbursementChannelId = disbursementChannelId;
    }

    public String getFinanceTypeId() {
        return financeTypeId;
    }

    public void setFinanceTypeId(String financeTypeId) {
        this.financeTypeId = financeTypeId;
    }

    public String getFlowTypeId() {
        return flowTypeId;
    }

    public void setFlowTypeId(String flowTypeId) {
        this.flowTypeId = flowTypeId;
    }

    public Short getHumanitarian() {
        return humanitarian;
    }

    public void setHumanitarian(Short humanitarian) {
        this.humanitarian = humanitarian;
    }

    public String getProviderActivityIdentifier() {
        return providerActivityIdentifier;
    }

    public void setProviderActivityIdentifier(String providerActivityIdentifier) {
        this.providerActivityIdentifier = providerActivityIdentifier;
    }

    public String getProviderOrganizationId() {
        return providerOrganizationId;
    }

    public void setProviderOrganizationId(String providerOrganizationId) {
        this.providerOrganizationId = providerOrganizationId;
    }

    public String getRecipientActivityIdentifier() {
        return recipientActivityIdentifier;
    }

    public void setRecipientActivityIdentifier(String recipientActivityIdentifier) {
        this.recipientActivityIdentifier = recipientActivityIdentifier;
    }

    public String getRecipientCountryDescription() {
        return recipientCountryDescription;
    }

    public void setRecipientCountryDescription(String recipientCountryDescription) {
        this.recipientCountryDescription = recipientCountryDescription;
    }

    public String getRecipientCountryId() {
        return recipientCountryId;
    }

    public void setRecipientCountryId(String recipientCountryId) {
        this.recipientCountryId = recipientCountryId;
    }

    public String getRecipientOrganizationId() {
        return recipientOrganizationId;
    }

    public void setRecipientOrganizationId(String recipientOrganizationId) {
        this.recipientOrganizationId = recipientOrganizationId;
    }

    public String getRecipientRegionDescription() {
        return recipientRegionDescription;
    }

    public void setRecipientRegionDescription(String recipientRegionDescription) {
        this.recipientRegionDescription = recipientRegionDescription;
    }

    public String getRecipientRegionId() {
        return recipientRegionId;
    }

    public void setRecipientRegionId(String recipientRegionId) {
        this.recipientRegionId = recipientRegionId;
    }

    public String getTiedStatusId() {
        return tiedStatusId;
    }

    public void setTiedStatusId(String tiedStatusId) {
        this.tiedStatusId = tiedStatusId;
    }

    public Account getTransactionReceiptOnAccountId() {
        return transactionReceiptOnAccountId;
    }

    public void setTransactionReceiptOnAccountId(Account transactionReceiptOnAccountId) {
        this.transactionReceiptOnAccountId = transactionReceiptOnAccountId;
    }

    public PaymentSchedule getTransactionPaymentScheduleId() {
        return transactionPaymentScheduleId;
    }

    public void setTransactionPaymentScheduleId(PaymentSchedule transactionPaymentScheduleId) {
        this.transactionPaymentScheduleId = transactionPaymentScheduleId;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.Transactions[ transactionId=" + transactionId + " ]";
    }

}
