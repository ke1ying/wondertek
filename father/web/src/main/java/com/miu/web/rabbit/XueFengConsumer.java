package com.miu.web.rabbit;

import com.miu.service.UserRedPackService;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * rabbitMq流量削峰
 * */
@Component
public class XueFengConsumer {

    @Autowired
    private UserRedPackService userRedPackService;

    @RabbitListener(queuesToDeclare = @Queue(value = "info"))
    public void XueFengPro(String message) {
        System.out.println("消费：" + message);
        userRedPackService.getRedPack(message);
    }

}
