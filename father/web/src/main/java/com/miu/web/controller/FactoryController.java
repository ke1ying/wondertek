package com.miu.web.controller;

import com.miu.service.FactoryService;
import com.miu.service.factory.FactoryEventEwb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author keying
 */
@RestController
public class FactoryController {

    @Autowired
    @Qualifier("arriveServiceImpl")
    private FactoryService arriveServiceImpl;

    @Autowired
    @Qualifier("sendServiceImpl")
    private FactoryService sendServiceImpl;

    @Autowired
    private FactoryEventEwb factoryEventEwb;

    @RequestMapping("/factory")
    public void factory(){
        FactoryService factoryService = FactoryEventEwb.getByType("ARRIVE");
        factoryService.doCreate();
//        sendServiceImpl.doCreate();
    }
}