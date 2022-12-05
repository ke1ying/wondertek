package com.miu.web.huaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-24 18:18:58
 */
public class HwSF61 {

    /**
     * 将一个字符串中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
     * Jkdi234klowe90a3
     * Jkdi*234*klowe*90*a*3*
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                stringBuffer.append("*");
                while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    stringBuffer.append(s.charAt(i++));
                }
                stringBuffer.append("*");
            } else {
                stringBuffer.append(s.charAt(i++));
            }
        }
        System.out.println(stringBuffer.toString());
    }

}