package com.miu.web.factory;

/**
 * @author keying
 * @date 2022-11-07 21:05:51
 */
public class MainChicken {

    public static void main(String[] args) {
       /* SimpleChickenFactory simpleChickenFactory = new SimpleChickenFactory();
        Chicken chicken = simpleChickenFactory.getChicken("KFC");*/
        FactoryChicken factoryChicken = new FactoryChicken("BJ");
        Chicken chicken = factoryChicken.create("KFC");
        System.out.println(factoryChicken.getAddress());
        System.out.println(chicken);
    }

}