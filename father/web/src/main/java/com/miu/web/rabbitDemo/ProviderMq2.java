package com.miu.web.rabbitDemo;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

public class ProviderMq2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqTest.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();


        channel.queueDeclare("hello", true, false, true, null);

        for (int i = 1; i <= 20; i++) {
            channel.basicPublish("", "hello", MessageProperties.PERSISTENT_TEXT_PLAIN, (i + "hello rabbit").getBytes());
        }
        RabbitMqTest.closeConnection(channel, connection);
    }
}
