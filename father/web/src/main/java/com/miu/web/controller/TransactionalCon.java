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
    * 则 其他 方法一可以运行，此异常的回滚。
    * */
    @RequestMapping("/requiredTry")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredTry(){
            serviceTest.requiredTry();
            try {
                serviceTest.requiredTry2();
            }catch (Exception e){

            }

    }

    /*《============================required_new ====================》
    *
    * 若外围没有开启事务，内围开启的事务是相互隔离的，且不受外围抛出异常的影响
    *
    * */


    /*
    propagation.required_new
    外围方法开启事务情况下：
    第一个方法因为跟外围方法事务是同一个，所以回滚未成功。
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
    * 未捕获异常，
    * 则第三个方法里事务异常回滚影响外围事务，
    * 外围事务和方法一里的事务是同一个事务，
    * 方法二requires_new是新建的事务，直接相互隔离
    * 所以方法一和方法三都回滚
    * */
    @RequestMapping("/requiredNewTryNo")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredNewTryNo() {
        serviceTest.propagationRequired();
        serviceTest.propagationRequiredNew1();
        serviceTest2.propagationRequiredThrw();
    }

    /*
    *propagation requeired_new
    *若捕获异常，外围其他内事务不受影响
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

    /*<==================reqired_===========================>
    *
    * 外围未开启事务，内围事务相互独立的，且不受外围异常影响
    * */

    /*
    *嵌套nested内围位外围子事务，全部回滚
    * */
    @RequestMapping("/propagationNested")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void propagationNested() {
        serviceTest.propagationNested();
        serviceTest.propagationNested2();
        serviceTest2.propagationNested2Throw();
        throw new RuntimeException();
    }

    /*
     *
     * */
    @RequestMapping("/propagationNestedTry")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void propagationNestedTry() {
        serviceTest.propagationNested();
        serviceTest.propagationNested2();
        try {
            serviceTest2.propagationNested2Throw();
        }catch (Exception e){
            System.out.println("回滚。。");
        }
    }

}
