package com.miu.entity;

import java.io.Serializable;
import java.util.Date;

public class UserTest implements Serializable {

    private String sName;

    private String sAge;

    private Date sSex;

    public Date getsSex() {
        return sSex;
    }

    public void setsSex(Date sSex) {
        this.sSex = sSex;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAge() {
        return sAge;
    }

    public void setsAge(String sAge) {
        this.sAge = sAge;
    }
}
