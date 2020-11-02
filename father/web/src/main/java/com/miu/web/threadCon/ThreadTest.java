package com.miu.web.threadCon;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        Thread thread = new Thread(a);
        Thread threadB = new Thread(new ThreadB());
        thread.setPriority(10);
        thread.start();
        threadB.setPriority(2);
        threadB.start();
    }

     static class ThreadA implements Runnable{

        @Override
        public void run() {
            Thread.yield();
            for (int i = 0; i < 100; i++) {
                System.out.println("AAAAA"+i);
            }
        }
    }

    static class ThreadB  implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("BBBBB"+i);
            }
        }
    }
}
