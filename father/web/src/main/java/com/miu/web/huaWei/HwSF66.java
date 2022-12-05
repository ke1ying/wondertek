package com.miu.web.huaWei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-24 18:18:58
 */
public class HwSF66 {

    /**
     * 输入描述：
     * 输入两个只包含小写字母的字符串
     * <p>
     * 输出描述：
     * 输出一个整数，代表最大公共子串的长度
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            // 包含则直接输出
            if (s1.contains(s)) {
                System.out.println(s.length());
                continue;
            }

            int a = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int i1 = i; i1 <= s.length(); i1++) {
                    String newStr = s.substring(i,i1);
                    if(s1.contains(newStr)){
                        a = a<newStr.length()?newStr.length():a;
                    }
                }
            }
            System.out.println(a);


        }
    }

}