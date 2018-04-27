package com.zrq.entity;

import java.util.Date;

/**
 * Created by zrq on 2018-4-25.
 * 考试类
 */
public class Exam {
    private Integer id;
    private String name;
    private String description;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
