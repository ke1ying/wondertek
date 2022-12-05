package com.miu.web.factory.DY;

/**
 * @author keying
 * @date 2022-11-07 22:05:07
 */
public class DYOrderFactory extends OrderFactory{

    public DYOrderFactory(String channel) {
        super(channel);
    }

    @Override
    public void order() {
        System.out.println("下单");
    }

    @Override
    public void cancel() {

    }
}