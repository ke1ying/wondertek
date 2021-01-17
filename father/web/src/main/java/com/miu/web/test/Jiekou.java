package com.miu.web.test;

public interface Jiekou extends Jiekou2,Jiekou3{

    static String CESHI = "123";

     void sum1();

    default String getString1() {
        return null;
    }

    static void ss(){

    }

    default void z() {

    }
}
