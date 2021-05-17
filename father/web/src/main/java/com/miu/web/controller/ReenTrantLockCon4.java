package com.miu.web.controller;

import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockCon4 {
    /**
     * 限制时间trylock
     */
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread0 = new Thread(new TestThread0(reentrantLock));
        thread0.start();
        Thread thread1 = new Thread(new TestThread1(reentrantLock));
        thread1.start();
    }
}

class TestThread0 implements Runnable {
    ReentrantLock reentrantLock;

    public TestThread0() {
    }

    public TestThread0(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        if (reentrantLock.tryLock()) {
            try {
                System.out.println("进入" + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

class TestThread1 implements Runnable {
    ReentrantLock reentrantLock;

    public TestThread1() {

    }

    public TestThread1(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        if (reentrantLock.tryLock()) {
            try {
                System.out.println("进入" + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
