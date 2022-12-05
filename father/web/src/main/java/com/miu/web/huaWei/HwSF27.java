package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF27 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int z = 0;
        for (int i = 0; i < str.length(); i++) {
            // ABA
            int aba = threadABA(str, i, i);
            // ABBA
            int abba = threadABA(str, i, i + 1);
            int newZ = aba > abba ? aba : abba;

            z = z > newZ ? z : newZ;
        }
        System.out.println(z);
    }

    private static int threadABA(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

}