package com.miu.web.rabbit;

import com.miu.service.RedPackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * 流量削峰后台
 * */

@RestController
public class XueFengProvider {

    private Logger logger = LoggerFactory.getLogger(XueFengProvider.class);

    @Autowired
    private RedPackService redPackService;

    @RequestMapping("/XueFeng")
    @ResponseBody
    public void XueFengPro() {
        try {
            for (int i = 0; i < 1000; i++) {
                redPackService.getRedPack(String.valueOf(i));
            }
        } catch (Exception e) {
            logger.error("抢红包失败:" + e.getMessage());
        }
    }

}
