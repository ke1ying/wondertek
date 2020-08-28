package com.miu.service.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class HappySynThread extends Thread{

    private Logger logger = LoggerFactory.getLogger(HappySynThread.class);

    private CountDownLatch count;

    public HappySynThread(CountDownLatch count){
        this.count = count;
    }

    public void run(){
        logger.info("进入多线程！！");
        count.countDown();
    }

}
