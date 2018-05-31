package com.zrq.entity;

import org.springframework.stereotype.Component;

/**
 * Created by zrq on 2018-4-18.
 */
public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer role;
    private char sex;
    private String idnumber;
    private String eduback;
    private Address address;
    private String perimage;

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getEduback() {
        return eduback;
    }

    public void setEduback(String eduback) {
        this.eduback = eduback;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPerimage() {
        return perimage;
    }

    public void setPerimage(String perimage) {
        this.perimage = perimage;
    }
}
