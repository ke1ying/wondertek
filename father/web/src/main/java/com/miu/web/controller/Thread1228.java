package com.miu.web.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

/**
 * @author keying
 * @date 2022-12-28 14:50:12
 */
public class Thread1228 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("线程运行");
            }
        });

        thread.start();
        System.out.println("执行start后...");
//        thread.run();
        LockSupport.unpark(thread);
        System.out.println("执行unPark后...");

    }


}