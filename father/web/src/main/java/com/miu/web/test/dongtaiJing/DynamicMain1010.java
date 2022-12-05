package com.miu.web.test.dongtaiJing;

import java.lang.reflect.Proxy;

/**
 * @author keying
 * @date 2022-10-10 19:28:18
 */
public class DynamicMain1010 {

    public static void main(String[] args) {
        BuyServiceImpl buyServiceImpl = new BuyServiceImpl();
        BuyBusService proxyBuy =(BuyBusService) Proxy.newProxyInstance(BuyBusService.class.getClassLoader(),
                new Class[]{BuyBusService.class}, new DynamicProxyHandler(buyServiceImpl));
        proxyBuy.buyBus();
    }
}