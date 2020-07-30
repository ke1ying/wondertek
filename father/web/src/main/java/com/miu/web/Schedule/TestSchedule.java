package com.miu.web.Schedule;

import com.miu.web.util.RedisTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class TestSchedule extends Thread{

    private static JedisPool pool = null;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(500);
        // 设置最大空闲数
        config.setMaxIdle(100);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "127.0.0.1", 6379, 300000);
    }

    private static final Logger log = LoggerFactory.getLogger(TestSchedule.class);

 /*   @Autowired
    private JedisPool jedisPool;*/

    //过期时间30秒
    public static final long expire=30000L;

    @Autowired
    private RedisTool redisTool;

    @Scheduled(cron = "50 51 17 * * ?")
    public void test() throws InterruptedException {
        String keyLock = "keYing";
        String requestId = UUID.randomUUID().toString();
        if(redisTool.lock(pool,keyLock,requestId)){
            log.info(">>>>>>>>>>>>>>>>>>>>> get lock success <<<<<<<<<<<<<<<<<<<<<<<<<,");
            sleep(5000);
            redisTool.unLock(pool,keyLock,requestId);
        }else{
            log.error(">>>>>>>>>>>>>>>>>>>>> get lock fail <<<<<<<<<<<<<<<<<<<<<<<<<,");
        }
    }

}
