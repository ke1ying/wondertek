package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-14 11:15:07
 */
public class HwSF49 {

    /**
     * 输入描述：
     * 输入一个仅包含小写字母的字符串
     * <p>
     * 输出描述：
     * 返回最长回文子串的长度
     * <p>
     * 1、穷举，列举所有情况
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length(); j > i; j--) {
                String hw = str.substring(i, j);
                if (isHw(hw)) {
                    max = hw.length() > max ? hw.length() : max;
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isHw(String hw) {
        return hw.equals(new StringBuffer(hw).reverse().toString());
    }


}