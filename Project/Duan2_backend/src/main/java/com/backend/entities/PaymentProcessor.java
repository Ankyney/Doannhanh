/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author pc3-cellx
 */
@Entity
@Table(name = "PaymentProcessor")
@NamedQueries({
    @NamedQuery(name = "PaymentProcessor.findAll", query = "SELECT p FROM PaymentProcessor p")})
public class PaymentProcessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "paymentProcessorId")
    private String paymentProcessorId;
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

    public PaymentProcessor() {
    }

    public PaymentProcessor(String paymentProcessorId) {
        this.paymentProcessorId = paymentProcessorId;
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

    public String getPaymentProcessorId() {
        return paymentProcessorId;
    }

    public void setPaymentProcessorId(String paymentProcessorId) {
        this.paymentProcessorId = paymentProcessorId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentProcessorId != null ? paymentProcessorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentProcessor)) {
            return false;
        }
        PaymentProcessor other = (PaymentProcessor) object;
        if ((this.paymentProcessorId == null && other.paymentProcessorId != null) || (this.paymentProcessorId != null && !this.paymentProcessorId.equals(other.paymentProcessorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.PaymentProcessor[ paymentProcessorId=" + paymentProcessorId + " ]";
    }
    
}
