package com.miu.web.controller;

import com.google.common.util.concurrent.RateLimiter;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author keying
 */
public class TokenBucketController2 {

    /**
     * 限流策略:1秒两个请求
     */
    private final RateLimiter limiter = RateLimiter.create(2.0);

    @GetMapping("/test")
    public String test() {
        // 500ms没获取到令牌直接false
        boolean tryAcquire = limiter.tryAcquire(500, TimeUnit.MILLISECONDS);
        if (!tryAcquire) {
            System.out.println("失败");
            return "未获取到令牌";
        }
        return "请求成功";
    }

    private void sendMsg() {
    }
}