/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.entities;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc3-cellx
 */
@Entity
@Table(name = "PaymentMethod")
@NamedQueries({
    @NamedQuery(name = "PaymentMethod.findAll", query = "SELECT p FROM PaymentMethod p")})
public class PaymentMethod implements Serializable {

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
    @Column(name = "paymentMethodId")
    private String paymentMethodId;
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
    @Size(max = 2147483647)
    @Column(name = "comments")
    private String comments;
    @Size(max = 50)
    @Column(name = "contactId")
    private String contactId;
    @Column(name = "isDefault")
    private Short isDefault;
    @Column(name = "lastAuthenticationStatus")
    private Integer lastAuthenticationStatus;
    @Size(max = 500)
    @Column(name = "lastAuthenticationStatus_display")
    private String lastAuthenticationStatusdisplay;
    @Column(name = "lastAuthenticationStatusDate")
    @Temporal(TemporalType.DATE)
    private Date lastAuthenticationStatusDate;
    @Size(max = 500)
    @Column(name = "lastAuthenticationStatusDetail")
    private String lastAuthenticationStatusDetail;
    @Size(max = 2147483647)
    @Column(name = "lastAuthenticationStatusTechnicalDetail")
    private String lastAuthenticationStatusTechnicalDetail;
    @Size(max = 50)
    @Column(name = "paymentScheduleId")
    private String paymentScheduleId;
    @Size(max = 50)
    @Column(name = "payorId")
    private String payorId;
    @Column(name = "type")
    private Integer type;
    @Size(max = 500)
    @Column(name = "type_display")
    private String typeDisplay;
    @JoinColumn(name = "transactionId", referencedColumnName = "transactionId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Transactions transactionId;

    public PaymentMethod() {
    }

    public PaymentMethod(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
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

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public Short getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Short isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getLastAuthenticationStatus() {
        return lastAuthenticationStatus;
    }

    public void setLastAuthenticationStatus(Integer lastAuthenticationStatus) {
        this.lastAuthenticationStatus = lastAuthenticationStatus;
    }

    public String getLastAuthenticationStatusdisplay() {
        return lastAuthenticationStatusdisplay;
    }

    public void setLastAuthenticationStatusdisplay(String lastAuthenticationStatusdisplay) {
        this.lastAuthenticationStatusdisplay = lastAuthenticationStatusdisplay;
    }

    public Date getLastAuthenticationStatusDate() {
        return lastAuthenticationStatusDate;
    }

    public void setLastAuthenticationStatusDate(Date lastAuthenticationStatusDate) {
        this.lastAuthenticationStatusDate = lastAuthenticationStatusDate;
    }

    public String getLastAuthenticationStatusDetail() {
        return lastAuthenticationStatusDetail;
    }

    public void setLastAuthenticationStatusDetail(String lastAuthenticationStatusDetail) {
        this.lastAuthenticationStatusDetail = lastAuthenticationStatusDetail;
    }

    public String getLastAuthenticationStatusTechnicalDetail() {
        return lastAuthenticationStatusTechnicalDetail;
    }

    public void setLastAuthenticationStatusTechnicalDetail(String lastAuthenticationStatusTechnicalDetail) {
        this.lastAuthenticationStatusTechnicalDetail = lastAuthenticationStatusTechnicalDetail;
    }

    public String getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(String paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public String getPayorId() {
        return payorId;
    }

    public void setPayorId(String payorId) {
        this.payorId = payorId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeDisplay() {
        return typeDisplay;
    }

    public void setTypeDisplay(String typeDisplay) {
        this.typeDisplay = typeDisplay;
    }

    public Transactions getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transactions transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod other = (PaymentMethod) object;
        if ((this.paymentMethodId == null && other.paymentMethodId != null) || (this.paymentMethodId != null && !this.paymentMethodId.equals(other.paymentMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.PaymentMethod[ paymentMethodId=" + paymentMethodId + " ]";
    }
    
}
