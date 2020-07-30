package com.miu.service.impl;

import com.miu.entity.User;
import com.miu.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther keying
 * @Date 2020/7/30
 */

@Service
public class TestServicelmpl extends TestService<User> {


    @Override
    protected List<User> getData() {
        return null;
    }
}
