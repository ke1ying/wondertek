package com.miu.web.rabbit;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component//queue默认：持久化，false非独占，不自动删除队列
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class Consumer {

    @RabbitHandler
    public void receivel(String message) {
        System.out.println("rabbitmq消费：" + message);
    }

}
