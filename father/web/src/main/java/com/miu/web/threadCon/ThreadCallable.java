package com.miu.web.threadCon;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       ThreadA threadA = new ThreadA();
        FutureTask<String> result = new FutureTask<>(threadA);
        new Thread(result).start();

        //等线程结束获取值
        System.out.println(result.get());
    }

    static class ThreadA implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("进入线程");

            return "进入线程";
        }
    }
}
