package com.miu.web.threadCon;

import java.util.concurrent.*;

public class ExecutorCallAble {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor tpe = (ThreadPoolExecutor)executorService;
        for (int i = 0; i < 10; i++) {
            ThreadA threadA = new ThreadA();
            FutureTask<String> result = new FutureTask<>(threadA);
            executorService.submit(result);
            String z = result.get();
            System.out.println("获取返回值:"+z);

          /*  int ActiveCount = tpe.getActiveCount();
            System.out.println("活跃线程："+ActiveCount);
            int poolSize = tpe.getPoolSize();
            System.out.println("获取当前线程池线程数量："+poolSize);*/
        }
      /*  int largePoolSize = tpe.getLargestPoolSize();
        System.out.println("线程池曾经创建过最大线程数量："+largePoolSize);
        long TaskCount = tpe.getTaskCount();
        long competed = tpe.getCompletedTaskCount();

        System.out.println("需要执行任务数："+TaskCount);
        System.out.println("已完成的线程任务数："+competed);*/
        executorService.shutdown();
    }

    static class ThreadA implements Callable<String> {


        @Override
        public String call() throws Exception {
                System.out.println("当前线程执行中："+Thread.currentThread().getName());
            return Thread.currentThread().getName();
        }
    }
}
