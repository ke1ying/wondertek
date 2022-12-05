package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF29 {
    /**
     *
     * 0-0 0-1 0-2
     * 1-0 1-1
     * 2-0
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer z = Integer.valueOf(str);

        int x = 1;
        // 定义二级数组
        int[][] result = new int[z][];
        for (int i = 0; i < z; i++) {
            // 每一行多少数
            result[i] = new int[z - i];
            // i+1 代表 每次放入多少数，第一次放一个，第二次放两个
            for (int j = 0; j < i +1; j++) {
                result[i-j][j] = x;
                x++;
            }
        }

        for (int[] re: result) {
            for (int r: re) {
                System.out.print(r+" ");
            }
            System.out.println();
        }
    }

}