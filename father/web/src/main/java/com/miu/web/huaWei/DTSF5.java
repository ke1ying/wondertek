package com.miu.web.huaWei;

/**
 * @author keying
 * @date 2022-11-19 17:26:08
 */
public class DTSF5 {

    /**
     * 背包5kg，物品为三个，
     * {1,2,4} 重量
     * {6,10,12}价值
     * dp 行代表物品，列代表容量。
     */
    public static void main(String[] args) {
        int[] value = {6, 10, 12};
        int[] weight = {1, 2, 4};
        int num = 3;
        int kg = 5;
        int[][] dp = new int[num + 1][kg + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= kg; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i-1][j],
                            dp[i-1][j-weight[i-1]] + value[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[num][kg]);

      /*  int[][] kv = new int[3][2];
        kv[0][0] = 1;
        kv[0][1] = 6;
        kv[1][0] = 2;
        kv[1][1] = 10;
        kv[2][0] = 4;
        kv[2][1] = 12;

        int num = 3;
        int kg = 5;
        int[] dp = new int[kg + 1];
        // 先循环物体
        // 在循环kg
        for (int i = 0; i < num; i++) {
            // 背包是否放得下
            for (int j = kg; j >= kv[i][0]; j--) {
                // 本身价值 + 剩余重量最大价值
                dp[j] = Math.max(dp[j - 1], dp[j - kv[i][0]] + kv[i][1]);
            }
        }
        System.out.println(dp[dp.length-1]);*/
    }

}