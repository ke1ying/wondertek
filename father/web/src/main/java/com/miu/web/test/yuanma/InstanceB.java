package com.miu.web.test.yuanma;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2022-11-01 07:25:19
 */
@Component
public class InstanceB {

    @Autowired
    private InstanceA instanceA;

    public InstanceA getInstanceA() {
        return instanceA;
    }

    public void setInstanceA(InstanceA instanceA) {
         this.instanceA = instanceA;
    }

    public InstanceB(InstanceA instanceA) {
        this.instanceA = instanceA;
    }

    public InstanceB() {
        System.out.println("实例化B");
    }
}