package com.miu.web.controller;

import com.miu.service.threadPool.HappySynThread;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

@Controller
public class HappySynchronized {

    @Resource
    @Qualifier("initThreadPool")
    private Executor executor;

    @RequestMapping("/threadTest")
    @ResponseBody
    public void suo() throws Exception {
        CountDownLatch count = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            HappySynThread hst = new HappySynThread(count);
            executor.execute(hst);
        }
        count.await();
    }

}
