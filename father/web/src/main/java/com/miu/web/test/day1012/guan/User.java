package com.miu.web.test.day1012.guan;

/**
 * @author keying
 * @date 2022-10-12 14:27:03
 */
public class User implements Observer {
    private String name;
    private String msg;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        this.msg = msg;
        read();
    }

    private void read() {
        System.out.println(this.name + "msg:" + this.msg);
    }


}