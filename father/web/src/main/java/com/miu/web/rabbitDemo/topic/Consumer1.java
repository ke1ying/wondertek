package com.miu.web.rabbitDemo.topic;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics", "topic");
        //虚拟队列
        String queue = channel.queueDeclare().getQueue();
        //绑定虚拟队列，交换机,路由key
        channel.queueBind(queue, "topics", "user.*");
        //确定消息
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("1、获取消息:" + new String(body));
            }
        });
    }
}
