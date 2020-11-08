package com.miu.web.threadCon;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockTest {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA("线程A");
        ThreadA threadB = new ThreadA("线程B");

        for (int i = 0; i < 100; i++) {
            new Thread(threadA).start();
        }


    }

    static class ThreadA implements Runnable {
        private String name;

        private static Integer num = 100;

        ThreadA(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("进入" + name + num--);
        }
    }

}
