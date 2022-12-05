package com.miu.web.factory;

/**
 * @author keying
 * @date 2022-11-07 21:01:40
 */
public class SimpleChickenFactory {

    /**
     * 通过传递的参数
     */
    public Chicken getChicken(String name){
        Chicken chicken = null;
        if(name.equals("KFC")){
            chicken = new KFCChicken();
        }else if(name.equals("MC")){
            chicken = new MCChicken();
        }
        return chicken;
    }

}