package com.miu.service.impl;

import com.miu.dao.mapper.RedPackMapper;
import com.miu.service.RedPackService;
import com.miu.service.UserRedPackService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedPackServicelmpl implements RedPackService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RedPackMapper redPackMapper;

    @Override
    public void getRedPack(String userId) {
        rabbitTemplate.convertAndSend("info", userId);
    }

    @Override
    public Integer getTotal(String id) {
        return redPackMapper.getTotal(id);
    }

    @Override
    public int updateRemain(String id) {
        return redPackMapper.updateRemain(id);
    }
}
