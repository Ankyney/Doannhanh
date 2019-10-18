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
 * @author pc3-cellx
 */
@Entity
@Table(name = "MainAccount")
@NamedQueries({
    @NamedQuery(name = "MainAccount.findAll", query = "SELECT m FROM MainAccount m")})
public class MainAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mainAccountId")
    private String mainAccountId;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "number")
    private String number;
    @Size(max = 50)
    @Column(name = "mainAccountCategoryKey")
    private String mainAccountCategoryKey;
    @Size(max = 50)
    @Column(name = "currencyKey")
    private String currencyKey;
//    @OneToMany(mappedBy = "mainAccountKey", fetch = FetchType.LAZY)
//    private List<FinancialActivity> financialActivityList;

    public MainAccount() {
    }

    public MainAccount(String mainAccountId) {
        this.mainAccountId = mainAccountId;
    }

    public String getMainAccountId() {
        return mainAccountId;
    }

    public void setMainAccountId(String mainAccountId) {
        this.mainAccountId = mainAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMainAccountCategoryKey() {
        return mainAccountCategoryKey;
    }

    public void setMainAccountCategoryKey(String mainAccountCategoryKey) {
        this.mainAccountCategoryKey = mainAccountCategoryKey;
    }

    public String getCurrencyKey() {
        return currencyKey;
    }

    public void setCurrencyKey(String currencyKey) {
        this.currencyKey = currencyKey;
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
        hash += (mainAccountId != null ? mainAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MainAccount)) {
            return false;
        }
        MainAccount other = (MainAccount) object;
        if ((this.mainAccountId == null && other.mainAccountId != null) || (this.mainAccountId != null && !this.mainAccountId.equals(other.mainAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.MainAccount[ mainAccountId=" + mainAccountId + " ]";
    }
    
}
