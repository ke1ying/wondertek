package com.miu.web.controller;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCon2 {

    /**
     * 公平锁
     *
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new TestThread(i));
            thread.start();
        }
    }

    static class TestThread implements Runnable {
        Integer z;

        public TestThread(Integer i) {
            this.z = i;
        }

        @Override
        public void run() {
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
            for (int i = 0; i < 2; i++) {
                System.out.println("获取锁的线程"+"==="+z);
            }
        }
    }
}
