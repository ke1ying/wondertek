package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF20 {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            } else {
                getThree(num, 0);
            }

        }
    }

    private static void getThree(int num, int i) {
        // 先除以3
        int first = num / 3;
        int second = num % 3;

        i = i + first;
        num = first + second;
        if (num == 2 || num == 3) {
            i = i + 1;

            System.out.println(i);
        } else if (num == 1) {
            System.out.println(i);
            return;
        } else {
            getThree(num, i);
        }
    }

}