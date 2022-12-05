package com.miu.web.controller.callback.function;

/**
 * @author keying
 * @date 2022-12-05 20:07:05
 */
public class Boss221205 implements CallbackInterface {

    private Employee221205 employee221205;

    public Boss221205(Employee221205 employee221205){
        this.employee221205 = employee221205;
    }

    public void question(){
        employee221205.question(this);
    }

    @Override
    public void callbackMethod() {

    }

    @Override
    public void tellBoss(String answer) {
        System.out.println("回答boss:" + answer);
    }
}