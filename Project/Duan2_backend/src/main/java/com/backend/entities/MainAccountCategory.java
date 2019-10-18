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
@Table(name = "MainAccountCategory")
@NamedQueries({
    @NamedQuery(name = "MainAccountCategory.findAll", query = "SELECT m FROM MainAccountCategory m")})
public class MainAccountCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mainAccountCategoryId")
    private String mainAccountCategoryId;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Column(name = "isClosed")
    private Short isClosed;
    @Column(name = "accountType")
    private Integer accountType;
    @Size(max = 500)
    @Column(name = "accountType_display")
    private String accountTypedisplay;
//    @OneToMany(mappedBy = "mainAccountCategoryKey", fetch = FetchType.LAZY)
//    private List<FinancialActivity> financialActivityList;

    public MainAccountCategory() {
    }

    public MainAccountCategory(String mainAccountCategoryId) {
        this.mainAccountCategoryId = mainAccountCategoryId;
    }

    public String getMainAccountCategoryId() {
        return mainAccountCategoryId;
    }

    public void setMainAccountCategoryId(String mainAccountCategoryId) {
        this.mainAccountCategoryId = mainAccountCategoryId;
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

    public Short getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Short isClosed) {
        this.isClosed = isClosed;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypedisplay() {
        return accountTypedisplay;
    }

    public void setAccountTypedisplay(String accountTypedisplay) {
        this.accountTypedisplay = accountTypedisplay;
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
        hash += (mainAccountCategoryId != null ? mainAccountCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MainAccountCategory)) {
            return false;
        }
        MainAccountCategory other = (MainAccountCategory) object;
        if ((this.mainAccountCategoryId == null && other.mainAccountCategoryId != null) || (this.mainAccountCategoryId != null && !this.mainAccountCategoryId.equals(other.mainAccountCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phuthang.entities.MainAccountCategory[ mainAccountCategoryId=" + mainAccountCategoryId + " ]";
    }
    
}
