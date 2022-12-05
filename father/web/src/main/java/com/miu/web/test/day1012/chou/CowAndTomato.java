package com.miu.web.test.day1012.chou;

/**
 * @author keying
 * @date 2022-10-12 13:37:34
 */
public class CowAndTomato extends Dish{

    @Override
    public void preparation() {
        System.out.println("准备牛肉和番茄");
    }

    @Override
    public void doing() {
        System.out.println("炒番茄炖牛腩");
    }

    @Override
    public void client() {
        System.out.println("给客户端吃");
    }
}