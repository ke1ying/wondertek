package com.miu.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miu.entity.User;
import com.miu.service.ServiceTest;
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
    private TestSchedule testSchedule;

    @Autowired
    private RestTemplate restTemplate;

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
        String url = "http://test.migucloud.com/internalApi";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        JSONObject param = new JSONObject();
        param.put("mod", "Cas");
        param.put("act", "Signup");
        param.put("sign", "MD5('CasSignup123456789')");
        param.put("mer_code", "010100001");
        param.put("username", "test_101");
        param.put("email", "12345678@qq.com");
        param.put("password", "123456");
        String json = restTemplate.postForObject(url, param, String.class);
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String, Object> map = (Map) JSON.parse(jsonObject.toString());
        if (!"0".equals(map.get("status"))) {
            System.out.println("返回错误：" + map.get("msg"));
        }
        map.get("data");
    }

}


