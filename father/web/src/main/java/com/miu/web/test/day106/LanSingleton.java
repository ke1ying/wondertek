package com.miu.web.test.day106;

/**
 * @author keying
 * @date 2022-10-07 10:46:52
 */
public class LanSingleton {
    private static volatile Singleton singleton = null;

    private LanSingleton() {

    }

    private static synchronized Singleton getInstance() {
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}


class Singleton {

}