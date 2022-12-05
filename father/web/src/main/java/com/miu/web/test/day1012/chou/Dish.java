package com.miu.web.test.day1012.chou;

/**
 * @author keying
 * @date 2022-10-12 13:34:58
 */
public abstract class Dish {

    void doDish(){
        this.preparation();
        this.doing();
        this.client();
    }

    public abstract void preparation();

    public abstract void doing();

    public abstract void client();
}