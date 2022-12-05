package com.miu.web.test.day1012;

/**
 * @author keying
 * @date 2022-10-12 11:25:28
 */
public class Environment1012 {
    private Strategy strategy;

    Environment1012(Strategy strategy){
        this.strategy = strategy;
    }

    public int calculate(int a,int b){
        return strategy.calc(a,b);
    }
}