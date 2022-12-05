package com.miu.web.test.day1011;

/**
 * @author keying
 * @date 2022-10-11 14:48:21
 */
public class Fang {
    private Deng deng;
    private Door door;

    public void open(){
        System.out.println("进入房间");
        deng.open();
        door.open();
    }
    public void close(){
        System.out.println("出去房间");
        deng.close();
        door.close();
    }
}