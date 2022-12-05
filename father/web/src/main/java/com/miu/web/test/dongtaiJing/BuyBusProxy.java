package com.miu.web.test.dongtaiJing;

/**
 * @author keying
 * @date 2022-10-10 19:14:51
 */
public class BuyBusProxy implements BuyBusService {

    private BuyServiceImpl buyService;

    BuyBusProxy(BuyServiceImpl buyService){
        this.buyService = buyService;
    }

    @Override
    public void buyBus() {
        // 买车前干啥
        buyService.buyBus();
        // 买车后干啥
    }
}