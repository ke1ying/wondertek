package com.miu.web.huaWei;

import com.miu.service.threadPool.ThreadPool;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author keying
 * @date 2022-08-11 09:14:53
 */
public class DuoXian {
    public static void main(String[] args) {
        int max = 90000000;

        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5,7,60L,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(300));
        long start = new Date().getTime();
        for (int i = 0; i < 300; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < max; j++) {

                    }
                }
            });
        }
        System.out.println("耗费："+(new Date().getTime() - start));
        executor.shutdown();
    }


}