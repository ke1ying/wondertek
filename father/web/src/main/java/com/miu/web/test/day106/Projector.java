package com.miu.web.test.day106;

/**
 * @author keying
 * @date 2022-10-07 15:13:10
 */
public class Projector<T> {
    public void projection(T t) {
        if (t instanceof VGA) {
            System.out.println("开始投影");
        }else{
            System.out.println("接口不匹配");
        }

    }
}