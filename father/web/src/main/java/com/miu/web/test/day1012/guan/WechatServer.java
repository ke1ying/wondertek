package com.miu.web.test.day1012.guan;

import jodd.util.CollectionUtil;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author keying
 * @date 2022-10-12 14:16:56
 */
public class WechatServer implements Subject{

    private List<Observer> observerList;
    private String msg;

    public WechatServer(){
        observerList = Lists.newArrayList();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!CollectionUtils.isEmpty(observerList)){
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o: observerList) {
            o.update(this.msg);
        }
    }

    public void setMsg(String msg){
        this.msg = msg;
        notifyObserver();
    }
}