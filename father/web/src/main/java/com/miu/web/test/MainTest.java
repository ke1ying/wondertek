package com.miu.web.test;


public class MainTest {
    private int count;
    public static void main(String[] args) {
        int i = 5;
        int j = 5;
        System.out.println(~j);
        System.out.println(i + ~j);
    }

    float fun0(){
        int i = 1;
        return i;
    }

    float fun1(){
        byte i = 1;
        return i;
    }
}
