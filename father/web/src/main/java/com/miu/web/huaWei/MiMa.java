package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-09-01 17:04:29
 */
public class MiMa {
    /**
     * 密码验证合格程序
     * * 021Abc9Abc1
     * * 1.长度超过8位
     * * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        validation(str);
    }

    private static void validation(String str) {
        //  1.长度超过8位
        if (str.length() <= 8) {
            System.out.println("不合格");
            return;
        }

        // 2.包括大小写字母.数字.其它符号,以上四种至少三种
        int little = 0;
        int max = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a') {
                little = 1;
            } else if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                max = 1;
            } else if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                num = 1;
            } else {
                other = 1;
            }
        }

        if (little + max + num + other < 3) {
            System.out.println("不合格");
            return;
        }

        // 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
        boolean flag = getTwoLength(str, 0, 2);
        if (!flag) {
            System.out.println("不合格");
        } else {
            System.out.println("合格");
        }

    }

    private static boolean getTwoLength(String str, int s, int e) {
        if(e > str.length()){
            return true;
        }
        if (!str.substring(e).contains(str.substring(s, e))) {
            s = s + 1;
            e = e + 1;
            return getTwoLength(str, s, e);
        } else {
            return false;
        }
    }
}