package com.miu.web.huaWei;

import lombok.Data;

/**
 * @author keying
 */
public class Synchronized822 {

    public static void main(String[] args) throws InterruptedException {
        ThreadTestNei threadTestNei = new ThreadTestNei();
        ThreadA threadA = new ThreadA(threadTestNei);
        threadA.setName("A-THREAD");
        threadA.start();

        ThreadB threadB = new ThreadB(threadTestNei);
        threadB.setName("B-THREAD");
        threadB.start();

    }

}

class ThreadA extends Thread {

    private ThreadTestNei threadTestNei;

    ThreadA(ThreadTestNei threadTestNei) {
        this.threadTestNei = threadTestNei;
    }

    @Override
    public void run() {
        super.run();
        threadTestNei.setUser();
    }
}

class ThreadB extends Thread {

    private ThreadTestNei threadTestNei;

    ThreadB(ThreadTestNei threadTestNei) {
        this.threadTestNei = threadTestNei;
    }

    @Override
    public void run() {
        super.run();
        threadTestNei.setUser();
    }
}

@Data
class ThreadTestNei {

    private String name;
    private String aString = new String();

    public synchronized static void setUser() {
        try {
           // synchronized (ThreadTestNei.class) {
                System.out.println(Thread.currentThread().getName() + "----" + "begin");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "----" + "end");
          //  }
        } catch (Exception e) {

        }

    }
}