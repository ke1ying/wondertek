package com.miu.web.test.day106.abs;

import com.miu.web.test.day106.CheesePizza;
import com.miu.web.test.day106.GreekPizza;
import com.miu.web.test.day106.Pizza;
import org.apache.xmlbeans.impl.xb.xsdschema.All;

/**
 * @author keying
 * @date 2022-10-07 09:42:50
 */
public class LDOrderPizza  extends AllPizza {

    public LDOrderPizza(String address) {
        super(address);
    }

    @Override
    public Pizza createPizza(String pizzaType) {
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