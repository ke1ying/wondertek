package com.miu.web.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockCon {
    /**
     * 中断响应实例
     */

    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        Thread thread1 = new Thread(new TestThread(lock1));
        Thread thread2 = new Thread(new TestThread2(lock1));
        thread1.start();
        thread2.start();
        //中断线程
        thread2.interrupt();
    }

    static class TestThread implements Runnable {
        Lock firstName;

        public TestThread(Lock firstName) {
            this.firstName = firstName;
        }

        @Override
        public void run() {
            try {
                System.out.println("进入" + Thread.currentThread().getName());
                firstName.lockInterruptibly();
                Thread.sleep(5000);
            } catch (Exception e) {

            } finally {
                firstName.unlock();
                System.out.println(Thread.currentThread().getName() + "结束！！");
            }
        }
    }

    static class TestThread2 implements Runnable {
        Lock firstName;

        public TestThread2(Lock firstName) {
            this.firstName = firstName;
        }

        @Override
        public void run() {
            try {
                System.out.println("进入" + Thread.currentThread().getName());
                firstName.lockInterruptibly();
                Thread.sleep(5000);
            } catch (Exception e) {
            } finally {
                firstName.unlock();
                System.out.println(Thread.currentThread().getName() + "结束！！");
            }
        }
    }
}
