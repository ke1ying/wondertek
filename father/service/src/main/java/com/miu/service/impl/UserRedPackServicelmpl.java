package com.miu.service.impl;

import com.miu.dao.mapper.UserRedPackMapper;
import com.miu.entity.UserRedpack;
import com.miu.service.RedPackService;
import com.miu.service.UserRedPackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class UserRedPackServicelmpl implements UserRedPackService {

    private Logger log = LoggerFactory.getLogger(UserRedPackServicelmpl.class);

    private static final int redpackId = 1;
    private static final String amount = "10.00";

    @Autowired
    private RedPackService redPackService;

    @Autowired
    private UserRedPackService userRedPackService;

    @Resource
    private UserRedPackMapper userRedPackMapper;

    @Override
    public void getRedPack(String message) {
        //单服务器才适用
        Integer remain = redPackService.getTotal("999999");
        if (remain > 0) {
            int result = redPackService.updateRemain("999999");
            if (result > 0) {
                //插入抢红包数据
                UserRedpack urp = new UserRedpack();
                urp.setUserid(message);
                urp.setRedpackid(redpackId);
                urp.setGrabdate(new Date());
                urp.setAmount(new BigDecimal(amount));
                userRedPackService.insertGradReadPack(urp);
            }
        }
    }

    @Override
    public void insertGradReadPack(UserRedpack urp) {
        userRedPackMapper.insertGradReadPack(urp);
    }
}
