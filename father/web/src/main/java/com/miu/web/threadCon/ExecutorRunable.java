package com.miu.web.threadCon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorRunable {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            ThreadA threadA = new ThreadA();
//            executorService.execute(threadA);
            executorService.submit(threadA);
        }
        executorService.shutdown();
    }


    static class ThreadA implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("进入线程:"+Thread.currentThread().getName());
            }
        }
    }
}
