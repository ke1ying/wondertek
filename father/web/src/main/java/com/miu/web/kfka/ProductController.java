package com.miu.web.kfka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author keying
 */
@Component
public class ProductController {
    @Resource
    private KafkaTemplate kafkaTemplate;

    public void send(String name){
        kafkaTemplate.send("user", "张三");
    }
}