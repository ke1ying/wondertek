package com.miu.web.controller;

public class ThreadTest implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"线程睡眠后!");
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
         new Thread(test).start();
        System.out.println("打印");
    }
}
