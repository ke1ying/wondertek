package com.miu.web.factory;

/**
 * @author keying
 * @date 2022-11-07 21:21:42
 */
public abstract class AllChicken implements ChickenInterface{

    private String address;

    public AllChicken(String address){
        this.address = address;
    }

}