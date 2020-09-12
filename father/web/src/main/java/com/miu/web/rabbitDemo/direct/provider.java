package com.miu.web.rabbitDemo.direct;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("log_direct", "direct");

        String routingKey = "info";
        //第三个参数持久化
        channel.basicPublish("log_direct", routingKey, null, ("provider" + routingKey).getBytes());
        RabbitMqTest.closeConnection(channel, connection);
    }
}
