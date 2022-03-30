//package com.miu.web.controller.redisson;
//
//import lombok.extern.log4j.Log4j2;
//import org.redisson.RedissonLock;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//@RestController
//@Log4j2
//public class RedissonController {
//
//    @Resource
//    private RedissonClient redissonClient;
//    private static int a = 50;
//
//    @RequestMapping("/redis_test")
//    public String redisTest() {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    RLock rLock = redissonClient.getLock("zhangsan");
//                    //rLock.lock();
//                   // log.info("获取锁成功！");
//                    try {
//                        //业务逻辑，存储入DB
//                        //加锁，最多等待10s，10s之后自动释放锁
//                        if (rLock.tryLock(10, 10, TimeUnit.SECONDS)) {
//                            Thread.sleep(50);
//                            if (a > 0) {
//                                a--;
//                            }
//                        }
//                    } catch (Exception e) {
//                    } finally {
//                        //释放锁
//                        if (rLock.isLocked()) {
//                            rLock.unlock();
//                        }
//                    }
//                  //  log.info("最后剩余：" + a);
//                }
//            });
//        }
//        executorService.shutdown();
//
//        return "success";
//    }
//
//    private void threadTest() {
//       /* RLock rLock = redissonClient.getLock("zhangsan");
//        rLock.lock();*/
//       // log.info("获取锁成功！");
//        try {
//            //业务逻辑，存储入DB
//            Thread.sleep(50);
//            a--;
//        } catch (Exception e) {
//
//        } finally {
////            rLock.unlock();
//        }
//      //  log.info("最后剩余：" + a);
//    }
//
//
//}
//
