package com.miu.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miu.entity.User;
import com.miu.service.ServiceTest;
import com.miu.service.TestService;
import com.miu.web.Schedule.TestSchedule;
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
    public User showAll() throws InterruptedException {
        //ServiceTest serviceTest = new ServiceTest();
        //定时器
        //testSchedule.test();
        serviceTest.testRedis();
        return serviceTest.showService();
    }

    @RequestMapping("/wondertek")
    @ResponseBody
    public void wondertek() {
        //new TestStaticBlock().test();
        testService.exportExcel();
    }

}


