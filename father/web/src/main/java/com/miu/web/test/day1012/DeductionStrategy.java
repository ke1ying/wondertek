package com.miu.web.test.day1012;

/**
 * @author keying
 * @date 2022-10-12 11:23:05
 */
public class DeductionStrategy implements Strategy{

    @Override
    public int calc(int a, int b) {
        return a - b;
    }
}