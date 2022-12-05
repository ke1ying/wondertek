package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-09-05 15:45:52
 */
public class Rmen0905 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] s = str.split("\\.");
        String first = s[0];
        String second = "0." + s[1];
        if(Double.valueOf(second) >= 0.5){
            System.out.println(Integer.valueOf(first) + 1);
        }else{
            System.out.println(first);
        }

    }
}