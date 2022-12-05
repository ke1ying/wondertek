package com.miu.web.huaWei;

/**
 * @author keying
 * @date 2022-11-16 14:52:04
 */
public class DongTaiGuiHua3 {

    /**
     * 体重1，价值6   体重2 价值10   体重4 价值12
     * 背包体积是5
     */
    public static void main(String[] args) {
        int[][] wp = new int[3][2];
        wp[0][0] = 1;
        wp[0][1] = 6;
        wp[1][0] = 2;
        wp[1][1] = 10;
        wp[2][0] = 4;
        wp[2][1] = 12;

        int[] dp = new int[5 + 1];
        // 先循环物体
        // 再循环重量
        // 当前 物体重量 小于等于 背包重量
        // 减去当前物体的 重量 求出 剩余重量的最大价值   +  当前重量物体的价值
        for (int i = 0; i < 3; i++) {
            // 当前 物体重量 小于等于 背包重量
            for (int j = dp.length - 1; j >= wp[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wp[i][0]] + wp[i][1]);
            }
        }
        System.out.println(dp[dp.length - 1]);
    }

}