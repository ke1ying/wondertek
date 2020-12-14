package com.miu.web.controller;

import com.miu.service.ServiceTest;
import com.miu.service.UserTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalCon {

    @Autowired
    private ServiceTest serviceTest;

    @Autowired
    private UserTest2 serviceTest2;

    /*
    * 默认事务传播，传播要求，
    * 当前存在事务，则直接加入存在事务执行，若不存在事务，则创建事务执行，
    * */
    @RequestMapping("/propagationRequired")
    @ResponseBody
    public void propagationRequired() {
        serviceTest.propagationRequired1();
        serviceTest.propagationRequired2();
    }

    /*
    * try catch捕获到异常，
    * 则 其他 方法一可以运行，异常的回滚。
    * */
    @RequestMapping("/requiredTry")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredTry(){

            serviceTest.requiredTry();


    }

    /*
    propagation.required_new
    外围方法开启事务情况下：第一个方法因为跟外围方法事务是同一个，所以回滚未成功。
    第二个和第二个都是new了新的事务，所以不回滚。

    * */
    @RequestMapping("/requiredNew")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredNew(){
        serviceTest.propagationRequired();
        serviceTest.propagationRequiredNew1();
        serviceTest2.propagationRequiredNew1();
        throw new RuntimeException();
    }


    /*
    *propagation requeirednew
    *
    *
    * */
    @RequestMapping("/requiredNewTry")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredNewTry() {
        serviceTest.propagationRequired();
        serviceTest.propagationRequiredNew1();
        try {
            serviceTest2.propagationRequiredThrw();
        } catch (Exception e) {
            System.out.println("回滚");
        }

    }
}
