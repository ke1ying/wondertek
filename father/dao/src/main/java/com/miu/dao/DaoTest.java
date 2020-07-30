package com.miu.dao;

import com.miu.entity.EntityTest;

public class DaoTest {

    public String showDao(){
        EntityTest entityTest = new EntityTest();
        return entityTest.showEntity()+":我是dao！";
    }
}
