/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.beans.responses;

import com.backend.entities.AdminRole;
import com.backend.entities.Company;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pc3-cellx
 */
public class ResponseAuth implements Serializable {

    private String username;
    private String fullName;
    private Company companyID;
    private AdminRole adminRoleID;
    private Integer id;
    private String token;
    private Date expireDate;

    public ResponseAuth(String username, String token, Date expireDate) {
        this.username = username;
        this.token = token;
        this.expireDate = expireDate;
    }

    public ResponseAuth() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    public AdminRole getAdminRoleID() {
        return adminRoleID;
    }

    public void setAdminRoleID(AdminRole adminRoleID) {
        this.adminRoleID = adminRoleID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
