package com.miu.web.controller;

import com.miu.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @RequestMapping("/mongoDB")
    @ResponseBody
    public void test() throws InterruptedException {
        System.out.println("测试");
        mongoService.insert();
        mongoService.findAll();
//        System.out.println(GradeEnum.HIGH.getSchool());
        //new TestSchedule().test();
    }
}
