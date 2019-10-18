package com.backend.entities;
// Generated Sep 24, 2019 11:35:14 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name="Company"
)
public class Company  implements java.io.Serializable {


     private int id;
     private String address;
     private String code;
     private Date createdDate;
     private String email;
     private Boolean isActive;
     private Boolean isDeleted;
     private String mobile;
     private String name;
     private String urlAvatar;

    public Company() {
    }

    public Company(String address, String code, Date createdDate, String email, Boolean isActive, Boolean isDeleted, String mobile, String name, String urlAvatar) {
       this.address = address;
       this.code = code;
       this.createdDate = createdDate;
       this.email = email;
       this.isActive = isActive;
       this.isDeleted = isDeleted;
       this.mobile = mobile;
       this.name = name;
       this.urlAvatar = urlAvatar;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", nullable=false, insertable=false, updatable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="Address")
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="code")
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreatedDate", insertable=false, updatable=false, length=23)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name="Email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="IsActive", insertable=false)
    public Boolean getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    
    @Column(name="IsDeleted", insertable=false, updatable=false)
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    
    @Column(name="Mobile")
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="UrlAvatar")
    public String getUrlAvatar() {
        return this.urlAvatar;
    }
    
    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }




}

