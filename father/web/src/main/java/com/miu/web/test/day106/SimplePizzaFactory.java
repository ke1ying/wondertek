package com.miu.web.test.day106;

/**
 * @author keying
 * @date 2022-10-07 09:28:20
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String pizzaType){
        Pizza pizza = null;
        if(pizzaType.equals("greek")){
            pizza = new GreekPizza();
            return pizza;
        }
        if(pizzaType.equals("cheese")){
            pizza = new CheesePizza();
            return pizza;
        }
        return null;
    }
}