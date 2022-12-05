package com.miu.web.huaWei;

/**
 * @author keying
 * @date 2022-11-16 14:52:04
 */
public class DongTaiGuiHua2 {

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
        int[][] wp = new int[3][2];
        // 体重1，价值6   体重2 价值10   体重4 价值12
        wp[0][0] = 1;
        wp[0][1] = 6;
        wp[1][0] = 2;
        wp[1][1] = 10;
        wp[2][0] = 4;
        wp[2][1] = 12;

        int[] dp = new int[5+1];

        // 分别循环三个物体
        for (int i = 0; i < 3; i++) {
            // j = dp长度    ，j >= 当前物体的重量
            for (int j = dp.length-1; j >= wp[i][0]; j--) {
                System.out.println("j=============" + j);
                System.out.println("wp[i][0]==============" + wp[i][0]);
                System.out.println("wp[i][1]==============" + wp[i][1]);
                System.out.println("dp[j - wp[i][0]] + wp[i][1]==============" + (dp[j - wp[i][0]] + wp[i][1]));
                // 总体积 - 当前物体的体积 求得 剩余体积最大价值 是多少  + 自己物体的价值
                dp[j] = Math.max(dp[j], dp[j - wp[i][0]] + wp[i][1]);
            }
        }

        System.out.println(dp[dp.length - 1]);

    }

}