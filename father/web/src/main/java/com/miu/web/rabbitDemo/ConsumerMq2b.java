package com.miu.web.rabbitDemo;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.*;

import java.io.IOException;

public class ConsumerMq2b {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello", true, false, true, null);

        channel.basicQos(1);//每次只能消费一个消息
        channel.basicConsume("hello", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("二消费者==" + new String(body));
                //手动确认1、手动确认参数标志。2、false表示每次确认一个
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
