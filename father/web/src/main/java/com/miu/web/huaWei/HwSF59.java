package com.miu.web.huaWei;

import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-23 15:58:55
 */
public class HwSF59 {

    /**
     * 等差数列
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int start = 2;
        for (int i = 1; i < num; i++) {
            int newNum = start + 3;
            start = start + newNum;
        }
        System.out.println(start);
    }

}