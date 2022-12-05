package com.miu.web.huaWei;

/**
 * @author keying
 * @date 2022-11-16 14:52:04
 */
public class DongTaiGuiHua4 {

    /**
     * 背包5kg，物品为三个，
     * {1,2,4} 重量
     * {6,10,12}价值
     * dp 行代表物品，列代表容量。
     */
    public static void main(String[] args) {
        int[] value = {6, 10, 12};
        int[] weight = {1, 2, 4};

        int wu = 3;
        int kg = 5;

        int[][] dp = new int[wu + 1][kg + 1];

        // 循环物体
        // 循环重量
        // 当前物体的重量必须小于等于 背包容量
        // 当前物体价值 + 剩余重量价值
        for (int i = 1; i <= wu; i++) {
            for (int j = 1; j <= kg; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    // 放入上一列的
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 1; i <= wu; i++) {
            System.out.print("第"+i+"个物品"+"      ");
            for (int j = 1; j <= kg; j++) {
                System.out.print(dp[i][j]+"      ");
            }
            System.out.println("");
        }

        System.out.println(dp[wu][kg]);
    }

}