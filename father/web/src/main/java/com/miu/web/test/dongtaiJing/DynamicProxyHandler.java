package com.miu.web.test.dongtaiJing;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author keying
 * @date 2022-10-10 19:23:46
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object object;

    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        System.out.println("执行前");
        Object result = method.invoke(object, args);
        System.out.println("执行后");
        return result;
    }
}