package com.miu.web.controller.callback.function2;

/**
 * @author keying
 * @date 2022-12-05 22:08:50
 */
public class Test20221205 implements CallbackZf{

    public void buy(CallbackZf callbackZf){
        System.out.println("买东西完毕");
        String num = "";
        callbackZf.success(num);
    }

    @Override
    public void success(String num) {
        System.out.println("返回"+num);
    }
}