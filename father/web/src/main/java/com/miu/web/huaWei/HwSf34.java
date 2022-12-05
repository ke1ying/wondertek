package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-09-09 14:38:34
 */
public class HwSf34 {

    /**
     * 迷宫问题
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Integer i1 = sc.nextInt();
            Integer i2 = sc.nextInt();

            int[][] mg = new int[i1][i2];
            for (int i = 0; i < i1; i++) {
                for (int j = 0; j < i2; j++) {
                    mg[i][j] = sc.nextInt();
                }
            }
            calculateMg(mg);

        }



    }

    private static void calculateMg(int[][] mg) {

    }
}