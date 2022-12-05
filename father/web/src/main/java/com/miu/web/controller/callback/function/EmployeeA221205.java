package com.miu.web.controller.callback.function;

/**
 * @author keying
 * @date 2022-12-05 20:11:43
 */
public class EmployeeA221205 implements Employee221205{

    @Override
    public void question(Boss221205 boss221205) {
        try{
            Thread.sleep(3000);
        }catch (Exception e){

        }

        // 回调
        boss221205.tellBoss("三秒后回调answer");
    }
}