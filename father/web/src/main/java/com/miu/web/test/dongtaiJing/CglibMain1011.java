package com.miu.web.test.dongtaiJing;

/**
 * @author keying
 * @date 2022-10-11 11:25:34
 */
public class CglibMain1011 {

    public static void main(String[] args) {
        BuyBusService buyBusService = new BuyServiceImpl();
        CglibProxy cglibProxy = new CglibProxy();
        BuyServiceImpl proxyBuy = (BuyServiceImpl)cglibProxy.getInstance(buyBusService);
        proxyBuy.buyBus();
    }

}