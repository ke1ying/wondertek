package com.miu.web.huaWei;

import lombok.val;

/**
 * @author keying
 * @date 2022-11-16 14:52:04
 */
public class DongTaiGuiHua {

    /**
     * 假设物体重量为w[i]  物体的价值为v[i]
     * dp[i][j]  其中i代表第i件物品，j代表此时背包的容量，
     * 那么我们就需要求得结果为dp[i][j]代表此时到第i件物品和背包容量为j时候获取的最大价值
     * <p>
     * 假设背包容量为10，物品为四个，
     * 重量w[i] = {2,3,4,7}
     * 价值v[i] = {1,3,5,9}
     * dp 行代表物品，列代表容量。
     */
    public static void main(String[] args) {
        // 重量
        int[] wight = {1, 2, 4};
        // 价值
        int[] value = {6, 10, 12};
        // 背包容量
        int w = 5;
        // 物体个数
        int n = value.length;
        // 定义一个二维数组，记录存放情况
        int[][] dp = new int[n + 1][w + 1];

        // 循环物体 类型
        for (int i = 1; i <= n; i++) {
            // 循环重量  5kg
            for (int j = 1; j <= w; j++) {
                // 当前物体小于体积 必须 小于 等于 背包体积
                if (wight[i - 1] <= j) {
                    System.out.println("wight[i - 1]===========" + wight[i - 1]);
                    System.out.println("dp[i - 1][j - wight[i - 1]]===========" + dp[i - 1][j - wight[i - 1]]);
                    // 物品本身的价值 + 当前物品剩余重量 最大价值
                    dp[i][j] = Math.max(
                            value[i - 1] + dp[i - 1][j - wight[i - 1]],
                            dp[i - 1][j]
                    );
                } else {
                    // 不能装，将上一个物体 的赋值过来
                    System.out.println("ELSE  === value:" + dp[i - 1][j]);
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("========================");
        for (int i = 1; i <= value.length; i++) {
            System.out.println("第" + i + "个物品" + "          ");
            for (int j = 1; j <= w; j++) {
                System.out.println(dp[i][j] + "      ");
            }
            System.out.println("  ");
        }

        System.out.println(dp[n][w]);

    }

}