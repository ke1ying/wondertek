package com.miu.web.test.day106.abs;

import com.miu.web.test.day106.Pizza;

/**
 * @author keying
 * @date 2022-10-07 09:39:46
 */
public abstract class AllPizza implements AbsFactory {

    private String address;

    public AllPizza(String address){
        this.address = address;
    }
}