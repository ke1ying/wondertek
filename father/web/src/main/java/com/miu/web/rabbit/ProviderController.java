package com.miu.web.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/providerHello")
    public void providerHello() {
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    /*
     * work模型
     * */
    @RequestMapping("/providerWorl")
    public void providerWorl() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "hello world" + i);
        }
    }

    /*
     * fanout广播
     * */
    @RequestMapping("/providerFanout")
    public void providerFanout() {
        rabbitTemplate.convertAndSend("logsFanout", null, "hello world");
    }

    /*
     * routing广播
     * */
    @RequestMapping("/providerRout")
    public void providerRout() {
        rabbitTemplate.convertAndSend("routingKey", "info", "hello world");
    }

    /*
    * topic
    * */
    @RequestMapping("/providerTopic")
    public void providerTopic() {
        rabbitTemplate.convertAndSend("topics", "user.name.zz", "hello world");
    }
}
