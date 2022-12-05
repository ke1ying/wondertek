package com.miu.web.huaWei;

import java.security.SecureRandom;

/**
 * @author keying
 * @date 2022-08-23 15:50:54
 */
public class Sync823 {

    public static void main(String[] args) {
        Service823 service823 = new Service823();
        ThreadA823 threadA823 = new ThreadA823(service823);
        threadA823.setName("鸣人");
        threadA823.start();

        Service823 service82311 = new Service823();
        ThreadB823 threadB823 = new ThreadB823(service82311);
        threadB823.setName("佐助");
        threadB823.start();
    }

}

class Service823{

    void thread823(){
        synchronized (Service823.class){
            for (int i = 0; i < 100; i++) {
                if(Thread.currentThread().getName().equals("鸣人")){
                    System.out.println("鸣人释放 螺旋丸");
                    continue;
                }
                System.out.println("佐助释放 千鸟");
            }
        }
    }
}

class ThreadA823 extends Thread{

    private Service823 service823;

    ThreadA823(Service823 service823){
        this.service823 = service823;
    }

    @Override
    public void run() {
        service823.thread823();
    }
}

class ThreadB823 extends Thread{

    private Service823 service823;

    ThreadB823(Service823 service823){
        this.service823 = service823;
    }

    @Override
    public void run() {
        service823.thread823();
    }
}