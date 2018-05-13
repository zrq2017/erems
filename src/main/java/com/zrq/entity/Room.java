package com.zrq.entity;

/**
 * 考点及考室结合地点及考室表
 * Created by zrq on 2018-5-12.
 */
public class Room {
    private Integer id;
    private String num;//编号
    private String name;//考点名
    private Integer size;//考点考室大小
    private String detail;
    private Address address;//考点归属区域

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
