package com.miu.dao.mapper;

import com.miu.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

//@Mapper
public interface UserMapper {
    List<User> selectAll();

    User selectById();
}
