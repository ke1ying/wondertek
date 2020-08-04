package com.miu.service.impl;

import com.miu.dao.mapper.UserMapper;
import com.miu.entity.User;
import com.miu.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServletTestImlp implements ServiceTest {


    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User showService() {
     /*   User zz = new User();
        List<User> li = new ArrayList<>();
        Optional<List<User>> list = Optional.ofNullable(userMapper.selectAll());
        Optional<User> optional =  Optional.ofNullable(userMapper.selectById());

        zz= optional.orElse(zz);
        zz.setSname("11");

        List<User> l = list.orElse(li);
        //错误的写法
        //Optional<User> user = userMapper.selectById();
        *//*if(user.isPresent()){
            System.out.println("存在："+user);
        }*//*

        //map可以将一个Optional对象转换成另一个，第一次是将Optional转换成了Optional，第二次是将Optional转成了另一个Optional，只是这次将字符串换成了大写；
        String s = optional.map(user1 -> user1.getSname()).map(user2 -> user2.toUpperCase()).orElse("no");
        return optional.orElse(null);*/
        return null;
    }

    @Override
    public void testRedis() {
        redisTemplate.opsForHash().put("hashValue", "map1", "map2");
        List<Object> hashList = redisTemplate.opsForHash().values("hashValue");
        System.out.println(hashList.get(0));
    }

    @Override
    public void saveNums() {
        long startDate = new Date().getTime();
      /*  for (int i = 8203; i < 10000000; i++) {
            String name = "name" + i;
            Integer sex = 0;
            userMapper.insert(name, sex);
        }*/
        long endDate = new Date().getTime();
        System.out.println("存储完毕，耗时：" + (endDate - startDate));
    }

}
