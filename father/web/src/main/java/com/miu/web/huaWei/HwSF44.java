package com.miu.web.huaWei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-10-13 13:36:15
 */
public class HwSF44 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            solution(num);
        }
    }

    private static void solution(int num) {
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        // 从2穷举
        for (int i = 2; i < num; i++) {
            if (isPrime(i) && isPrime(num - i)) {
                // 保存最接近的两个素数
                if (Math.abs(num - i - i) < min) {
                    res[0] = i;
                    res[1] = num - i;
                    min = Math.abs(num - i - i);
                }
            }
        }
        System.out.println(res[0] + "\n" + res[1]);
    }

    private static boolean isPrime(int i) {
        System.out.println(Math.sqrt(i));
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}