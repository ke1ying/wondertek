package com.miu.web.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqTest {

    private static ConnectionFactory connectionFactory;

    /*重量级工厂，类加载时候只加载一次*/
    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("106.15.45.177");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("ems");
    }

    public static Connection getConnection() {
        try {
            //获取连接对象
            Connection connection = connectionFactory.newConnection();
            return connection;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    //关闭连接
    public static void closeConnection(Channel channel, Connection connection) {
        try {
            if (null != channel) {
                channel.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
