package com.miu.web.test.day1012;

/**
 * @author keying
 * @date 2022-10-12 11:24:39
 */
public class Main1012 {
    public static void main(String[] args) {
        Environment1012 environment1012 = new Environment1012(new AddStrategy());
        System.out.println(environment1012.calculate(1,2));
    }
}