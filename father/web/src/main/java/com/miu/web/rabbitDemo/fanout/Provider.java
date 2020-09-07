package com.miu.web.rabbitDemo.fanout;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs","fanout");

        channel.basicPublish("logs","",null,"fanout message".getBytes());
        RabbitMqTest.closeConnection(channel,connection);
    }
}
