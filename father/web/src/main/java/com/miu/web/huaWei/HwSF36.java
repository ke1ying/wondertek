package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-09-09 15:29:22
 */
public class HwSF36 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer i = Integer.valueOf(br.readLine());
        System.out.println(str.substring(0,i));
    }

}