package com.miu.web.rabbit;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

//@Component
public class Consumer2 {

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receivel1(String message) {
        System.out.println("1、消费：" + message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receivel2(String message) {
        System.out.println("2、消费：" + message);
    }

    /*
     * fanout消费
     * */
    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue,//创建临时队列)
            exchange = @Exchange(value = "logsFanout", type = "fanout")
    )})
    public void receivelFanout1(String message) {
        System.out.println("1、fanout消费：" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logsFanout", type = "fanout")
            )
    })
    public void receivelFanout2(String message) {
        System.out.println("2、fanout消费：" + message);
    }

    /*
     * routing
     * */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "routingKey", type = "direct"),
                    key = {"info", "error"}
            )
    })
    public void recevicelRouting(String message) {
        System.out.println("1、routing消费：" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "routingKey", type = "direct"),
                    key = {"error"}
            )
    })
    public void recevicelRouting2(String message) {
        System.out.println("2、routing消费：" + message);
    }

    /*
     * topic模式
     * */
    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            value = @Queue,
                            exchange = @Exchange(value = "topics", type = "topic"),
                            key = {"user.*", "user.#"}
                    )
            }
    )
    public void rececivelTopic(String message) {
        System.out.println("1、topic消费者：" + message);
    }

    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            value = @Queue,
                            exchange = @Exchange(value = "topics", type = "topic"),
                            key = {"user.*"}
                    )
            }
    )
    public void rececivelTopic2(String message) {
        System.out.println("2、topic消费者：" + message);
    }

}
