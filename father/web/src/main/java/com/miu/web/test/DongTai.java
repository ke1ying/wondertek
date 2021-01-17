package com.miu.web.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 动态代理
* */

public class DongTai implements InvocationHandler {

    private Object objectTarget;

    //绑定关系，关联到哪个接口
    public Object newProxyInstance(Object objectTarget){
        this.objectTarget = objectTarget;
        /*
        * 三个参数,
        * 第1个：指定跟目标对象相同的加载类
        * 2:指定跟目标对象实现的接口
        * 3:表示执行哪个invoke方法
        * */
        return Proxy.newProxyInstance(objectTarget.getClass().getClassLoader(),
                objectTarget.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy表示代理，method表示原对象调用的方法，args表示方法参数
        System.out.println("start==========");
        for (int i = 0; i < args.length; i++) {
            System.out.println("方法："+args[i]);
        }

        Object ob = null;
        ob=method.invoke(objectTarget, args);

        return ob;
    }
}
