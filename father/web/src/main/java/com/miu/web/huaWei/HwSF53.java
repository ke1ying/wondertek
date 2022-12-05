package com.miu.web.huaWei;

import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-17 11:30:45
 */
public class HwSF53 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                num++;
            }
        }
        System.out.println(num);
    }

}