package com.miu.web.controller.callback.function;

/**
 * @author keying
 * @date 2022-12-05 19:54:25
 */
public class CallbackImpl implements CallbackInterface {

    @Override
    public void callbackMethod() {
        System.out.println("开始执行:callbackMethod");
    }

    @Override
    public void tellBoss(String answer) {

    }
}