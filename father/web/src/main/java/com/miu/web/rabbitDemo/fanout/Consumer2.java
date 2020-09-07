package com.miu.web.rabbitDemo.fanout;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs","fanout");
        //虚拟队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定队列
        channel.queueBind(queueName,"logs","");
        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("2、消费广播"+new String(body));
            }
        });
    }
}
