package com.miu.web.rabbitDemo;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerMq {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",true,false,true,null);

        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("===================================="+new String(body));
            }
        });

    }

}
