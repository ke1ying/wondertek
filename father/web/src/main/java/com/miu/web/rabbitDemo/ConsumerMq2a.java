package com.miu.web.rabbitDemo;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.*;

import java.io.IOException;

public class ConsumerMq2a {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello", true, false, true, null);

        channel.basicQos(1);//每次只能消费一个消息
        //false：不会自动确认。
        channel.basicConsume("hello", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.getMessage();
                }
                System.out.println("一消费者===" + new String(body));
                //手动确认1、手动确认参数标志。2、false表示每次确认一个（是否开启多个消息同时确认）
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
