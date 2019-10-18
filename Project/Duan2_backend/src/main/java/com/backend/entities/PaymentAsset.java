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
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author pc3-cellx
 */
@Entity
@Table(name = "PaymentAsset")
@NamedQueries({
        @NamedQuery(name = "PaymentAsset.findAll", query = "SELECT p FROM PaymentAsset p")})
public class PaymentAsset implements Serializable {

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
    @Column(name = "paymentAssetId")
    private String paymentAssetId;
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
    @Column(name = "assetType")
    private Integer assetType;
    @Size(max = 500)
    @Column(name = "assetType_display")
    private String assetTypedisplay;
    @Column(name = "bookDate")
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "originalAssetAdjustedId")
    private String originalAssetAdjustedId;
    @Size(max = 50)
    @Column(name = "paymentAssetPlannedGivingId")
    private String paymentAssetPlannedGivingId;
    @Size(max = 500)
    @Column(name = "paymentAssetPledgedAsset")
    private String paymentAssetPledgedAsset;
    @Column(name = "paymentAssetCategory")
    private Integer paymentAssetCategory;
    @Size(max = 500)
    @Column(name = "paymentAssetCategory_display")
    private String paymentAssetCategorydisplay;
    @Column(name = "paymentAssetSubcategory")
    private Integer paymentAssetSubcategory;
    @Size(max = 500)
    @Column(name = "paymentAssetSubcategory_display")
    private String paymentAssetSubcategorydisplay;
    @Size(max = 50)
    @Column(name = "pledgedOnPaymentScheduleId")
    private String pledgedOnPaymentScheduleId;
    @Column(name = "quantity")
    private BigDecimal quantity;
    @Size(max = 100)
    @Column(name = "symbol")
    private String symbol;
    @JoinColumn(name = "transferredOnTransactionId", referencedColumnName = "transactionId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Transactions transferredOnTransactionId;

    public PaymentAsset() {
    }

    public PaymentAsset(String paymentAssetId) {
        this.paymentAssetId = paymentAssetId;
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

    public String getPaymentAssetId() {
        return paymentAssetId;
    }

    public void setPaymentAssetId(String paymentAssetId) {
        this.paymentAssetId = paymentAssetId;
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

    public Integer getAssetType() {
        return assetType;
    }

    public void setAssetType(Integer assetType) {
        this.assetType = assetType;
    }

    public String getAssetTypedisplay() {
        return assetTypedisplay;
    }

    public void setAssetTypedisplay(String assetTypedisplay) {
        this.assetTypedisplay = assetTypedisplay;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalAssetAdjustedId() {
        return originalAssetAdjustedId;
    }

    public void setOriginalAssetAdjustedId(String originalAssetAdjustedId) {
        this.originalAssetAdjustedId = originalAssetAdjustedId;
    }

    public String getPaymentAssetPlannedGivingId() {
        return paymentAssetPlannedGivingId;
    }

    public void setPaymentAssetPlannedGivingId(String paymentAssetPlannedGivingId) {
        this.paymentAssetPlannedGivingId = paymentAssetPlannedGivingId;
    }

    public String getPaymentAssetPledgedAsset() {
        return paymentAssetPledgedAsset;
    }

    public void setPaymentAssetPledgedAsset(String paymentAssetPledgedAsset) {
        this.paymentAssetPledgedAsset = paymentAssetPledgedAsset;
    }

    public Integer getPaymentAssetCategory() {
        return paymentAssetCategory;
    }

    public void setPaymentAssetCategory(Integer paymentAssetCategory) {
        this.paymentAssetCategory = paymentAssetCategory;
    }

    public String getPaymentAssetCategorydisplay() {
        return paymentAssetCategorydisplay;
    }

    public void setPaymentAssetCategorydisplay(String paymentAssetCategorydisplay) {
        this.paymentAssetCategorydisplay = paymentAssetCategorydisplay;
    }

    public Integer getPaymentAssetSubcategory() {
        return paymentAssetSubcategory;
    }

    public void setPaymentAssetSubcategory(Integer paymentAssetSubcategory) {
        this.paymentAssetSubcategory = paymentAssetSubcategory;
    }

    public String getPaymentAssetSubcategorydisplay() {
        return paymentAssetSubcategorydisplay;
    }

    public void setPaymentAssetSubcategorydisplay(String paymentAssetSubcategorydisplay) {
        this.paymentAssetSubcategorydisplay = paymentAssetSubcategorydisplay;
    }

    public String getPledgedOnPaymentScheduleId() {
        return pledgedOnPaymentScheduleId;
    }

    public void setPledgedOnPaymentScheduleId(String pledgedOnPaymentScheduleId) {
        this.pledgedOnPaymentScheduleId = pledgedOnPaymentScheduleId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Transactions getTransferredOnTransactionId() {
        return transferredOnTransactionId;
    }

    public void setTransferredOnTransactionId(Transactions transferredOnTransactionId) {
        this.transferredOnTransactionId = transferredOnTransactionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentAssetId != null ? paymentAssetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentAsset)) {
            return false;
        }
        PaymentAsset other = (PaymentAsset) object;
        if ((this.paymentAssetId == null && other.paymentAssetId != null) || (this.paymentAssetId != null && !this.paymentAssetId.equals(other.paymentAssetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.PaymentAsset[ paymentAssetId=" + paymentAssetId + " ]";
    }

}
