package com.miu.web.factory.DY;

/**
 * @author keying
 * @date 2022-11-07 22:02:10
 */
public abstract class OrderFactory implements OrderInterface{

    private String channel;

    public OrderFactory(String channel){
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }
}