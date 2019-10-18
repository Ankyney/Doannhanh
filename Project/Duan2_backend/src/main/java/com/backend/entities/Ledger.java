/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ankyney
 */
@Entity
@Table(name = "Ledger")
@NamedQueries({
    @NamedQuery(name = "Ledger.findAll", query = "SELECT l FROM Ledger l")})
public class Ledger implements Serializable {

    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ledgerId")
    private String ledgerId;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "companyKey")
    private String companyKey;
    @Size(max = 50)
    @Column(name = "accountingCurrencyKey")
    private String accountingCurrencyKey;
//    @OneToMany(mappedBy = "ledgerId", fetch = FetchType.LAZY)
//    private List<FinancialActivity> financialActivityList;

    public Ledger() {
    }

    public Ledger(String ledgerId) {
        this.ledgerId = ledgerId;
    }

    public String getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(String ledgerId) {
        this.ledgerId = ledgerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyKey() {
        return companyKey;
    }

    public void setCompanyKey(String companyKey) {
        this.companyKey = companyKey;
    }

    public String getAccountingCurrencyKey() {
        return accountingCurrencyKey;
    }

    public void setAccountingCurrencyKey(String accountingCurrencyKey) {
        this.accountingCurrencyKey = accountingCurrencyKey;
    }

//    public List<FinancialActivity> getFinancialActivityList() {
//        return financialActivityList;
//    }
//
//    public void setFinancialActivityList(List<FinancialActivity> financialActivityList) {
//        this.financialActivityList = financialActivityList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ledgerId != null ? ledgerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ledger)) {
            return false;
        }
        Ledger other = (Ledger) object;
        if ((this.ledgerId == null && other.ledgerId != null) || (this.ledgerId != null && !this.ledgerId.equals(other.ledgerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.Ledger[ ledgerId=" + ledgerId + " ]";
    }
    
}
