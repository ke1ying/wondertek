package com.miu.web.controller;

import com.miu.entity.User;
import com.miu.service.ServiceTest;
import com.miu.service.TestService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebTest {

    @Autowired
    private ServiceTest serviceTest;

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    @ResponseBody
    public User showAll() throws Exception {
        //定时器
//        serviceTest.testRedis();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("106.15.45.177");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        //获取连接对象
        Connection connection = connectionFactory.newConnection();
        //获取链接通道
        Channel channel = connection.createChannel();

        //通道绑定参数消息队列
        //1、队列名称，不存在则自动创建
        //2、true：持久化到磁盘，false：不持久化，
        //3、true:独占队列，false:不独占
        //4、ture:队列消费完成自动删除。false:不删除。
        //5、额外附加参数
        channel.queueDeclare("hello", false, false, false, null);

        //发布消息
        //1、交换机名称
        //2、队列名称
        //3、传递消息额外设置
        //4、传递消息内容
        channel.basicPublish("", "hello", null, "hello rabbit".getBytes());
        channel.close();
        connection.close();

        return serviceTest.showService();
    }

    @RequestMapping("/wondertek")
    @ResponseBody
    public void wondertek() throws Exception {
        //new TestStaticBlock().test();
        //testService.exportExcel();
        //存储大数据1000万条数据
//        serviceTest.saveNums();
    }

}


