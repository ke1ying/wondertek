package com.miu.web.controller;

import com.miu.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalCon {

    @Autowired
    private ServiceTest serviceTest;

    @RequestMapping("/propagationRequired")
    @ResponseBody
    public void propagationRequired() {
        serviceTest.propagationRequired1();
        serviceTest.propagationRequired2();
    }
}
