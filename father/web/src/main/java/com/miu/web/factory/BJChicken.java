package com.miu.web.factory;

/**
 * @author keying
 * @date 2022-11-07 21:23:32
 */
public class BJChicken extends AllChicken{

    public BJChicken(String address) {
        super(address);
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