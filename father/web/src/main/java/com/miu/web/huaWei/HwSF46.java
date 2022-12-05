package com.miu.web.huaWei;

import java.util.Scanner;

/**
 * @author keying
 * @date 2022-10-13 13:36:15
 */
public class HwSF46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Integer apple = scanner.nextInt();
            Integer pan = scanner.nextInt();
            count(apple, pan);
        }
    }

    private static void count(Integer apple, Integer pan) {
        // 持有apple pan，总共有dp[i][j]种方法
        int[][] dp = new int[apple + 1][pan + 1];
        // 没有苹果的场景
        for (int i = 0; i <= pan; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= apple; i++) {
            for (int j = 1; j <= pan; j++) {
                if (i < j) {
                    // 苹果数 < 盘子数， 有空盘
                    // 则忽略一个盘子，在n-1个放苹果，一直递推到n == 1，有一种摆法
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // 苹果数 >= 盘子数，可以看做没有空盘
                    // 则可以选择忽略一个盘子
                    // 还可以选择每个盘子放一个苹果，即苹果数剩下i-j，继续递推到j==1
                    dp[i][j] = dp[i][j-1] + dp[i-j][j];
                }
            }
        }
        System.out.println(dp[apple][pan]);
    }


}