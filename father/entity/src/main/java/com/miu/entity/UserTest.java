package com.miu.entity;

import java.io.Serializable;

public class UserTest implements Serializable {

    private String sName;

    private String sAge;

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
