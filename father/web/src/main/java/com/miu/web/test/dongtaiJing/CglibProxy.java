package com.miu.web.test.dongtaiJing;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author keying
 * @date 2022-10-11 11:15:21
 */
public class CglibProxy implements MethodInterceptor {

    private Object object;
    public Object getInstance(Object object){
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.object.getClass());
        enhancer.setCallback(this);
        return enhancer;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行前准备");
        Object result = methodProxy.invoke(o,objects);
        System.out.println("执行后准备");
        return result;
    }
}