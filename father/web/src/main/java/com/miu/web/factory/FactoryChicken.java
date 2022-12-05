package com.miu.web.factory;

/**
 * @author keying
 * @date 2022-11-07 21:44:03
 */
public class FactoryChicken implements ChickenInterface{

    private String address;

    public FactoryChicken(String address) {
       this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    @Override
    public Chicken create(String name) {
        Chicken chicken = null;
        if(name.equals("KFC")){
            chicken = new KFCChicken();
        }else if(name.equals("MC")){
            chicken = new MCChicken();
        }
        return chicken;
    }
}