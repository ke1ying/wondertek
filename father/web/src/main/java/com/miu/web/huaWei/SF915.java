package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-09-15 21:43:53
 */
public class SF915 {

    /**
     * 1 3 6 10
     * 2 5 9
     * 4 8
     * 7
     * <p>
     * <p>
     * 0-0 0-1 0-2 0-3
     * 1-0 1-1 1-2
     * 2-0 2-1
     * 3-0
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.valueOf(br.readLine());
        int jia = 1;
        // 创建二级数组
        int er[][] = new int[num][];
        for (int i = 0; i < num; i++) {
            // 每级数组 存放多少数
            er[i] = new int[num - i];
            for (int j = 0; j < i + 1; j++) {
                er[i-j][j] = jia;
                jia++;
            }
        }
        for (int i = 0; i < er.length; i++) {
            for (int j = 0; j < er[i].length; j++) {
                System.out.print(er[i][j] + " ");
            }
            System.out.println();
        }
    }

}