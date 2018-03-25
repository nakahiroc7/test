package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="baby")
public class  Baby{
 
	@Id
    @Column(name="babyid")
    private Integer babyid;

    @Column(name="birthdate")
    private String birthdate;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="sex")
    private String sex;
 
    @Column(name="userid")
    private String userid;
 
    @Column(name="defaultselect")
    private Integer defaultselect;
 
    public Integer getBabyid() {
        return babyid;
    }
 
    public void setBabyid(Integer babyid) {
        this.babyid = babyid;
    }

    public String getBirthdate() {
        return birthdate;
    }
 
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public Integer getDefaultselect() {
        return defaultselect;
    }
    public void setDefaultselect(Integer defaultselect) {
        this.defaultselect = defaultselect;
    }



}

