package com.miu.web.controller.callback.function2;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author keying
 * @date 2022-12-05 22:09:58
 */
public class ZF20221205main {
    public static void main(String[] args) {
        Test20221205 test20221205 = new Test20221205();
        test20221205.buy(new CallbackZf() {
            @Override
            public void success(String num) {
                num = "string";
            }
        });
    }
}