package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author keying
 * @date 2022-08-12 15:43:54
 */
public class HwSF15 {
    /**
     * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer readInt = Integer.valueOf(br.readLine());
        String str = Integer.toBinaryString(readInt);
        int z = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == "1".charAt(0)){
                z++;
            }
        }
        System.out.println(z);
    }
}