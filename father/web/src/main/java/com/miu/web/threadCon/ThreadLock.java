package com.miu.web.threadCon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
       /* for (int i = 0; i < 30; i++) {
            ThreadA threadA = new ThreadA();
            executorService.execute(threadA);
        }*/
        ThreadA threadA = new ThreadA("线程1");
        ThreadA threadb = new ThreadA("线程2");
        ThreadA threadc = new ThreadA("线程3");
        executorService.execute(threadA);
        executorService.execute(threadb);
        executorService.execute(threadc);

        executorService.shutdown();
    }

    static class ThreadA implements Runnable{

        private Lock lock = new ReentrantLock();

        //火车票
        static Integer num = 100;

        private String threadName;

        ThreadA(String threadName){
            this.threadName = threadName;
        }

        @Override
        public void run() {
            while (num > 0){
                try {
                    lock.lock();
                    num--;
                    System.out.println(threadName+"线程执行完还剩余:"+num);
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
