package com.miu.web.test;

public class Test {
    public Test(){
        System.out.println(this.getClass().getClassLoader().toString());
    }
}
