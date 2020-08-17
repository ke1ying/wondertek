package com.miu.web.controller;

import com.miu.entity.User;
import com.miu.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RedisController {

    @Autowired
    private ServiceTest serviceTest;

    @ResponseBody
    @RequestMapping("/redisTestSave")
    public void redisMethod() {
        serviceTest.saveUserAll();
    }

    @ResponseBody
    @RequestMapping("/redisTestGet")
    public void redisGet() {
        serviceTest.getUserAll();
    }
}
