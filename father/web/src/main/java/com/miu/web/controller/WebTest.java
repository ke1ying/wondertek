package com.miu.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miu.entity.User;
import com.miu.service.ServiceTest;
import com.miu.service.TestService;
import com.miu.web.Schedule.TestSchedule;
import com.miu.web.rabbitDemo.ProviderMq;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

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
        channel.queueDeclare("hello",false,false,false,null);

        //发布消息
        //1、交换机名称
        //2、队列名称
        //3、传递消息额外设置
        //4、传递消息内容
        channel.basicPublish("","hello",null,"hello rabbit".getBytes());
        channel.close();
        connection.close();

        return serviceTest.showService();
    }

    @RequestMapping("/wondertek")
    @ResponseBody
    public void wondertek() {
        //new TestStaticBlock().test();
        //testService.exportExcel();

        //存储大数据1000万条数据
//        serviceTest.saveNums();
    }

    public static void main(String[] args) {
        int z = 2;
        z |= z>>>1;
        System.out.println(z);
        z |= z>>>2;
        System.out.println(z);
        z |= z>>>4;
        System.out.println(z);
        z |= z>>>8;
        System.out.println(z);
        z |= z>>>16;
        System.out.println(z);
    }
}


