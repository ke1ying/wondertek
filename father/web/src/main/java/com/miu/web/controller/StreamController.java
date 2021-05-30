package com.miu.web.controller;

import com.google.common.collect.Lists;
import com.miu.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamController {
    public static void main(String[] args) {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User("张三",3));
        listUsers.add(new User("李四",4));
        listUsers.add(new User("王五",5));
        listUsers.add(new User("null",6));
        /**
         * arraysLists 取出id转成String集合
         */
        List<Integer> integerList = listUsers.stream().map(User::getAge).collect(Collectors.toList());
        System.out.println("[取出id转成String集合]:"+integerList);
        /**
         * arraysLists 去重
         */
        List<User> distanctList = listUsers.stream().filter(user -> !user.getName().equals("null")).
                distinct().collect(Collectors.toList());
        System.out.println("[arraysLists 去重]:"+distanctList);

        /**
         * 处理 对象 转成map
         */
        Map<Integer, String> map =listUsers.stream().collect(Collectors.toMap(User::getAge,User::getName));
        System.out.println("[处理 对象 转成map]:"+map);

        /**
         * 处理 list对象 分组 转成list
         * 并且并行 处理数据
         */
        List<List<User>> partitionList = Lists.partition(listUsers,2);
        System.out.println(partitionList);
        List<User> parallelList = partitionList.parallelStream().map(model->{
            System.out.println("当前处理业务线程为："+Thread.currentThread().getName());
            return model;
        }).flatMap(Collection::stream).collect(Collectors.toList());


    }
}
