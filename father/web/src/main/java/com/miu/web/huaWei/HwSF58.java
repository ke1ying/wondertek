package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-23 15:58:55
 */
public class HwSF58 {

    /**
     * I am a student
     * tneduts a ma I
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int z = a;
            z = gong(a, b, z);
            System.out.println(z);
        }
    }

    /**
     * 保证小的在前面
     */
    private static int gong(int a, int b, int z) {
        if (a % b == 0) {
            return a;
        }
        return gong(a + z, b, z);
    }
}