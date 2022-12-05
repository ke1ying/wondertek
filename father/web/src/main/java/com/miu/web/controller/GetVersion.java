package com.miu.web.controller;
import com.miu.service.MongoService;
import com.miu.web.meiju.GradeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
public class GetVersion {

    @Value("${versionUrl}")
    private String versionUrl;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MongoService mongoService;

    @RequestMapping("/redis_setnx")
    @ResponseBody
    public String redisSetnx() throws InterruptedException {
        boolean f = redisTemplate.opsForValue().
                setIfAbsent("key_","value_111", 60L,TimeUnit.SECONDS);
        try{
            if(f){
                Thread.sleep(5000);
            }else{

            }
        }catch (Exception e){
            if(redisTemplate.hasKey("key_")){
                redisTemplate.delete("key_");
            }
        }

        return versionUrl;
    }

    @RequestMapping("/getVersion")
    @ResponseBody
    public String getVersion() throws Exception {
        System.out.println("versionUrl:" + versionUrl);
        return versionUrl;
    }

    /**
     * 是否是windows系统
     *
     * @return
     */
    private static boolean isWindows() {
        String osName = System.getProperty("os.name");
        if (osName != null && osName.toLowerCase().indexOf("win") >= 0) {
            return true;
        }
        return false;
    }

    @RequestMapping("/testOne")
    @ResponseBody
    public void test() throws InterruptedException {
        System.out.println("测试");
//        mongoService.insert();
//        mongoService.findAll();
//        System.out.println(GradeEnum.HIGH.getSchool());
        //new TestSchedule().test();
    }
}



