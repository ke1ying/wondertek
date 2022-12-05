package com.miu.web.test.day1012.chou;

/**
 * @author keying
 * @date 2022-10-12 13:37:34
 */
public class EggAndTomato extends Dish{

    @Override
    public void preparation() {
        System.out.println("准备鸡蛋和番茄");
    }

    @Override
    public void doing() {
        System.out.println("炒西红柿鸡蛋");
    }

    @Override
    public void client() {
        System.out.println("西红柿鸡蛋给客户端吃");
    }
}

