package com.miu.dao.mapper;

import com.miu.entity.User;
import com.miu.entity.UserTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

//@Mapper
public interface UserMapper {
    List<User> selectAll();

    User selectById();

    void insert(@Param("name") String name, @Param("sex") Integer sex);
}
