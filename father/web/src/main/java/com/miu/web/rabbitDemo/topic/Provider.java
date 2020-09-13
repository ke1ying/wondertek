package com.miu.web.rabbitDemo.topic;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics", "topic");
        String routKey = "user.name.z";
        channel.basicPublish("topics", routKey, null, ("topic消息：" + routKey).getBytes());
        RabbitMqTest.closeConnection(channel, connection);
    }
}
