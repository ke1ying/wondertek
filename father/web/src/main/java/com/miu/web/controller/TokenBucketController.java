package com.miu.web.controller;

import com.google.common.util.concurrent.RateLimiter;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.vavr.control.Try;
import org.apache.poi.ss.formula.functions.T;
import org.redisson.api.RateLimiterConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author keying
 */
public class TokenBucketController {

    private Jedis jedis;

    /**
     * 获取key
     *
     * @param userId    用户id
     * @param actionKey 行为key
     * @return key
     */
    public String key(String userId, String actionKey) {
        return String.format("filter:limit:%s:%s", userId, actionKey);
    }

    /**
     * 判断是否允许
     *
     * @param userId    用户id
     * @param actionKey 行为key
     * @param period    限流周期（秒）
     * @param maxCount  最大请求次数（滑动窗口大小）
     * @return
     */
    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws Exception {
        String key = this.key(userId, actionKey);
        long ts = System.currentTimeMillis();
        // 用redis管道可以实现
        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();
        // 添加当前时间元素
        pipeline.zadd(key, ts, String.valueOf(ts));
        // 移除超过时间元素
        pipeline.zremrangeByScore(key, 0, ts - (period * 1000));
        // 获取count
        Response<Long> countRes = pipeline.zcard(key);
        // 设置过期时间
        pipeline.expire(key,period);
        pipeline.exec();
        List<Object> objects = pipeline.syncAndReturnAll();
        boolean b = countRes.get() <= maxCount;
        pipeline.close();
        return b;
    }

    public static void main(String[] args) throws Exception {
        TokenBucketController tokenBucketController = new TokenBucketController();
        for (int i = 0; i < 20; i++) {
            boolean b = tokenBucketController.isActionAllowed("keying","view",60,5);
            System.out.println("第" + (i + 1) + "次操作" + (b ? "成功" : "失败"));
        }
        tokenBucketController.jedis.close();
    }
}