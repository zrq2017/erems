package com.zrq.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zrq on 2018-4-25.
 * 考试类
 */
public class Exam {
    private Integer id;
    private String name;
    private String description;
    private Integer outed;//过期标志，0未过期，1过期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public Exam() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOuted() {
        return outed;
    }

    public void setOuted(Integer outed) {
        this.outed = outed;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
