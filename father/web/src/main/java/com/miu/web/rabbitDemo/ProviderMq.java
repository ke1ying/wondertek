package com.miu.web.rabbitDemo;

import com.miu.web.util.RabbitMqTest;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProviderMq {

    public static void main(String[] args) throws IOException, TimeoutException {
        providerDemo();
    }

    private static void providerDemo() throws IOException, TimeoutException {
        Connection connection = RabbitMqTest.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();

        //通道绑定参数消息队列
        //1、队列名称，不存在则自动创建
        //2、true：持久化到磁盘，false：不持久化，（注意是队列，不是队列里的消息）
        //3、true:独占队列，false:不独占
        //4、ture:队列消费完成自动删除。false:不删除。
        //5、额外附加参数
        channel.queueDeclare("hello", true, false, true, null);

        //发布消息
        //1、交换机名称
        //2、队列名称
        //3、传递消息额外设置(MessageProperties.PERSISTENT_TEXT_PLAIN:表示消息持久化)
        //4、传递消息内容
        //channel.basicPublish("","hello",null,"hello rabbit".getBytes());
        channel.basicPublish("", "hello", MessageProperties.PERSISTENT_TEXT_PLAIN, "hello rabbit".getBytes());
        RabbitMqTest.closeConnection(channel, connection);
    }
}
