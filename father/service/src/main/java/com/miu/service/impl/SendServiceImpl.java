package com.miu.service.impl;

import com.miu.service.FactoryService;
import org.springframework.stereotype.Service;

/**
 * @author keying
 */
@Service
public class SendServiceImpl implements FactoryService {

    @Override
    public String getType() {
        return "SEND";
    }

    @Override
    public void doCreate() {
        System.out.println("SEND DO CREATE");
    }


}