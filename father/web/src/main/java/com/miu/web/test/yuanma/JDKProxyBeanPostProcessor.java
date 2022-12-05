package com.miu.web.test.yuanma;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

/**
 * @author keying
 * @date 2022-11-01 08:37:42
 */
public class JDKProxyBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        // 假设instanceA需要动态代理  (解析切点，aspect @PointCut)
        if(bean instanceof InstanceA){

        }
        return null;
    }
}