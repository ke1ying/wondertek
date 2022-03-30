package com.miu.web.kfka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author keying
 */
@Component
public class ConsumerKafka {

    @KafkaListener(id = "foo", topics = "kafka-boot")
    public void listen1(String foo) {
        System.out.println("消费" + foo);
    }
}