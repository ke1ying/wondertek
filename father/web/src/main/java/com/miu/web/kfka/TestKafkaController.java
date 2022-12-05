package com.miu.web.kfka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.errors.RetriableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
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
     * 异步发送
     *
     * @return
     */
    @RequestMapping("/sendKafka")
    public String syncSendMessage() {
        for (int i = 0; i < 10; i++) {
            try {
                // 1/异步调用
                // 2重试次数
                ProducerRecord producerRecord = new ProducerRecord("kafka-boot", "foo" + i);
                ProducerFactory factory = kafkaTemplate.getProducerFactory();
                Producer producer = factory.createProducer();
                producer.send(producerRecord, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        if (e == null) {
                            //成功
                        }else if(e instanceof RetriableException){
                            // 可重试
                        }else{
                            // 不可重试
                        }
                    }
                });
                //kafkaTemplate.send("kafka-boot", "0", "foo" + i).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "success";
    }

    /**
     * 同步发送
     *
     * @return
     */
    @RequestMapping("/sendKafka2")
    public String sendKafka2() {
        for (int i = 0; i < 10; i++) {
            try {
                // 1/异步调用
                // 2重试次数
                ProducerRecord producerRecord = new ProducerRecord("kafka-boot", "foo" + i);
                ProducerFactory factory = kafkaTemplate.getProducerFactory();
                Producer producer = factory.createProducer();
                producer.send(producerRecord, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        if (e == null) {
                            //成功
                        }else if(e instanceof RetriableException){
                            // 可重试
                        }else{
                            // 不可重试
                        }
                    }
                });
                //kafkaTemplate.send("kafka-boot", "0", "foo" + i).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "success";
    }


}