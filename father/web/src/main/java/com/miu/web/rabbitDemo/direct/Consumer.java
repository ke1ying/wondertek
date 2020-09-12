package com.miu.web.rabbitDemo.direct;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("log_direct", "direct");
        //创建虚拟队列
        String queue = channel.queueDeclare().getQueue();
        //绑定队列，交换机，路由key
        channel.queueBind(queue, "log_direct", "info");
        //消费队列，是否自动确认
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("1、消费成功:" + new String(body));
            }
        });

    }
}
