package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF18 {

    /**
     * 021Abc9Abc1
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            // 长度超过8位
            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            // 包括大小写字母.数字.其它符号,以上四种至少三种
            int count = getCount(str);
            if (count < 3) {
                System.out.println("NG");
                continue;
            }

            // 不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
            boolean flaTwo = getDistinct(str, 0, 3);
            if (flaTwo) {
                System.out.println("NG");
                continue;
            }

            System.out.println("OK");
        }
    }

    private static boolean getDistinct(String str, int i, int i1) {
       /* Boolean returnFlag = Boolean.FALSE;
        if (str.length() < i1) {
            return returnFlag;
        }

        String conta = str.substring(i, i1);
        if (str.substring(i1).contains(conta)) {
            returnFlag = Boolean.TRUE;
            return returnFlag;
        } else {
            getDistinct(str, i + 1, i1 + 1);
        }

        return returnFlag;*/
        if (str.length() < i1) {
            return false;
        }

        String conta = str.substring(i, i1);
        if (str.substring(i1).contains(conta)) {
            return Boolean.TRUE;
        } else {
            return getDistinct(str, i + 1, i1 + 1);
        }
    }

    private static int getCount(String str) {
        int count = 0;
        boolean xiaoXie = false;
        boolean daXie = false;
        boolean number = false;
        boolean other = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                xiaoXie = true;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                daXie = true;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                number = true;
            } else {
                other = true;
            }
        }

        if (xiaoXie) {
            count += 1;
        }
        if (number) {
            count += 1;
        }
        if (daXie) {
            count += 1;
        }
        if (other) {
            count += 1;
        }
        return count;
    }
}