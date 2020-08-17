package com.miu.service;


import com.miu.entity.User;

import java.util.List;

public interface ServiceTest {
    User showService();

    void testRedis();

    void saveNums();

    void getUserAll();

    void saveUserAll();
}
