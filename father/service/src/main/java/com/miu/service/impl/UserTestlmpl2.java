package com.miu.service.impl;

import com.miu.dao.mapper.UserTestMapper;
import com.miu.dao.mapper.UserTestMapper2;
import com.miu.entity.UserTest;
import com.miu.service.UserTest2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserTestlmpl2 implements UserTest2 {

    @Resource
    private UserTestMapper2 userTestMapper2;

    @Resource
    private UserTestMapper userTestMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiredNew1() {
        UserTest userTest = new UserTest();
        userTest.setsName("requeredNew2");
        userTest.setsAge("男");
        userTestMapper.inert2(userTest);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiredThrw() {
        UserTest userTest = new UserTest();
        userTest.setsName("requeredThrow");
        userTest.setsAge("男");
        userTestMapper.inert2(userTest);
        throw new RuntimeException();
    }
}
