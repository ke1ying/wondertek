package com.miu.service.impl;

import com.miu.service.FactoryService;
import org.springframework.stereotype.Service;

/**
 * @author keying
 */
@Service
public class ArriveServiceImpl implements FactoryService {

    @Override
    public String getType() {
        return "ARRIVE";
    }

    @Override
    public void doCreate() {
        System.out.println("ARRIVE DO CREATE");
    }
}