package com.miu.web.controller.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author keying
 * @date 2023-06-20 08:35:09
 */
@RestController
@RequestMapping("/redisson")
public class Redisson230620 {

    @Resource
    private RedissonClient redissonClient;

    /**
     * 锁
     */
    @RequestMapping("/fair_lock")
    public void redisTest() {
        RLock fairLock = redissonClient.getFairLock("anyLock");
        try{
            fairLock.lock();
            boolean b = fairLock.tryLock(10, TimeUnit.SECONDS);
            System.out.println("b:"+b);
            boolean b1 = fairLock.tryLock(3, 10, TimeUnit.SECONDS);
            System.out.println("b1"+b1);
        }catch (Exception e){

        }finally {
            if(fairLock.isLocked() && fairLock.isHeldByCurrentThread()){
                fairLock.unlock();
            }
        }


    }
}