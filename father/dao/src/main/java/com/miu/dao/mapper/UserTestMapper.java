package com.miu.dao.mapper;

import com.miu.entity.User;
import com.miu.entity.UserTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserTestMapper {

    List<UserTest> selectUserTest();

    void propagationRequired1();

    void propagationRequired2();
}
