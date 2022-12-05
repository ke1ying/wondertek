package com.miu.web.huaWei;

import java.util.Scanner;

/**
 * @author keying
 * @date 2022-12-01 16:57:29
 */
public class HwSF68 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int start = 2;
        int newNum = 2;
        for (int i = 1; i < num; i++) {
            start = start + 3;
            newNum += start;
        }
        System.out.println(newNum);
    }
}