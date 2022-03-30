package com.miu.web.kfka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author keying
 */
@RestController
public class TestKafkaController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 同步发送
     *
     * @return
     */
    @RequestMapping("/sendKafka")
    public String syncSendMessage() {
        for (int i = 0; i < 10; i++) {
            try {
                kafkaTemplate.send("kafka-boot", "0", "foo" + i).get();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "success";
    }


}