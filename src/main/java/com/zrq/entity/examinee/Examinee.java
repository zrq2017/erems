package com.zrq.entity.examinee;

import com.zrq.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by zrq on 2018-4-18.
 */
@Component
public class Examinee extends User {
    private char sex;
    private String idnumber;
    private String eduback;
    private String adress;
    private Integer type;

    public Examinee() {}

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
