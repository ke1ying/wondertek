package com.miu.web.threadCon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadA threadA1 = new ThreadA(1);
        ThreadA threadA2 = new ThreadA(2);
        executorService.execute(threadA1);
        executorService.execute(threadA2);

        executorService.shutdown();
    }

    static class ThreadA implements Runnable{
        private Integer id;

        private static Object obj1 = new Object();
        private static Object obj2 = new Object();

        ThreadA(Integer id){
            this.id = id;
        }

        @Override
        public void run() {
            if(id == 1){
                synchronized (obj1){
                    System.out.println("线程1拿到[obj1]对象锁");
                    try {
                        Thread.sleep(3000);
                    }catch (Exception e){

                    }
                    synchronized(obj2){
                        System.out.println("线程1拿到[obj2]对象锁");
                    }
                }
            }

            if(id == 2){
                zz();
                synchronized (obj2){
                    System.out.println("线程2拿到[obj2]对象锁");
                    try {
                        Thread.sleep(3000);
                    }catch (Exception e){

                    }
                    synchronized(obj1){
                        System.out.println("线程2拿到[obj1]对象锁");
                    }
                }
            }
        }

        //同步方法
        private static synchronized void zz() {
        }
    }

}
