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
 *
 * @author pc3-cellx
 */
@Entity
@Table(name = "CreditPlanRecipient")
@NamedQueries({
    @NamedQuery(name = "CreditPlanRecipient.findAll", query = "SELECT c FROM CreditPlanRecipient c")})
public class CreditPlanRecipient implements Serializable {

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
    @Column(name = "creditRecipientId")
    private String creditRecipientId;
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
    @Size(max = 500)
    @Column(name = "creditPlanRecipientCustomerIdType")
    private String creditPlanRecipientCustomerIdType;
    @Size(max = 50)
    @Column(name = "creditPlanRecipientCustomerId")
    private String creditPlanRecipientCustomerId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentageOfPayment")
    private BigDecimal percentageOfPayment;
    @Column(name = "softCreditReason")
    private Integer softCreditReason;
    @Size(max = 500)
    @Column(name = "softCreditReason_display")
    private String softCreditReasondisplay;
    @JoinColumn(name = "creditRecipientCreditPlanId", referencedColumnName = "creditPlanId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CreditPlan creditRecipientCreditPlanId;

    public CreditPlanRecipient() {
    }

    public CreditPlanRecipient(String creditRecipientId) {
        this.creditRecipientId = creditRecipientId;
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

    public String getCreditRecipientId() {
        return creditRecipientId;
    }

    public void setCreditRecipientId(String creditRecipientId) {
        this.creditRecipientId = creditRecipientId;
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

    public String getCreditPlanRecipientCustomerIdType() {
        return creditPlanRecipientCustomerIdType;
    }

    public void setCreditPlanRecipientCustomerIdType(String creditPlanRecipientCustomerIdType) {
        this.creditPlanRecipientCustomerIdType = creditPlanRecipientCustomerIdType;
    }

    public String getCreditPlanRecipientCustomerId() {
        return creditPlanRecipientCustomerId;
    }

    public void setCreditPlanRecipientCustomerId(String creditPlanRecipientCustomerId) {
        this.creditPlanRecipientCustomerId = creditPlanRecipientCustomerId;
    }

    public BigDecimal getPercentageOfPayment() {
        return percentageOfPayment;
    }

    public void setPercentageOfPayment(BigDecimal percentageOfPayment) {
        this.percentageOfPayment = percentageOfPayment;
    }

    public Integer getSoftCreditReason() {
        return softCreditReason;
    }

    public void setSoftCreditReason(Integer softCreditReason) {
        this.softCreditReason = softCreditReason;
    }

    public String getSoftCreditReasondisplay() {
        return softCreditReasondisplay;
    }

    public void setSoftCreditReasondisplay(String softCreditReasondisplay) {
        this.softCreditReasondisplay = softCreditReasondisplay;
    }

    public CreditPlan getCreditRecipientCreditPlanId() {
        return creditRecipientCreditPlanId;
    }

    public void setCreditRecipientCreditPlanId(CreditPlan creditRecipientCreditPlanId) {
        this.creditRecipientCreditPlanId = creditRecipientCreditPlanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditRecipientId != null ? creditRecipientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditPlanRecipient)) {
            return false;
        }
        CreditPlanRecipient other = (CreditPlanRecipient) object;
        if ((this.creditRecipientId == null && other.creditRecipientId != null) || (this.creditRecipientId != null && !this.creditRecipientId.equals(other.creditRecipientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.CreditPlanRecipient[ creditRecipientId=" + creditRecipientId + " ]";
    }
    
}
