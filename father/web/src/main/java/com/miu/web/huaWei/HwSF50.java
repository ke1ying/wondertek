package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-14 15:01:21
 */
public class HwSF50 {
    /**
     * 查找组成一个偶数最接近的两个素数
     * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，
     * 要求输出组成指定偶数的两个素数差值最小的素数对。
     * <p>
     * <p>
     * 素数的判断，先求平方根，在从2 遍历小于等于平方根， 数 除以 i是否 等于0
     * 1、从1穷举遍历，
     * 2、传入两个相加等于 输入数 的两位数，判断是否是素数
     * 3、算两个值相减 与之前相减的比较
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int one = 0;
        int two = 0;
        int min = Integer.MAX_VALUE;
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 2; i < num; i++) {
                if (isS(i) && isS(num - i)) {
                    if (Math.abs(num - i - i) < min) {
                        one = i;
                        two = num - i;
                        min = Math.min(two - one, min);
                    }
                }
            }
            System.out.println(one);
            System.out.println(two);
        }
    }

    private static boolean isS(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            // 不是素数
            if (i % j == 0) {
                return false;
            }
        }
        // 是素数
        return true;
    }


}