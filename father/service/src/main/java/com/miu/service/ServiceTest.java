package com.miu.service;


import com.miu.entity.User;

import java.util.List;

public interface ServiceTest {
    User showService();

    void testRedis();

    void saveNums();

    void getUserAll();

    void saveUserAll();

    void propagationRequired1();

    void propagationRequired2();

    void requiredTry();

    void propagationRequiredNew1();

    void propagationRequired();

    void propagationNested();

    void propagationNested2();

    void requiredTry2();
}
