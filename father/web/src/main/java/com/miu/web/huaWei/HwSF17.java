package com.miu.web.huaWei;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-08-23 18:43:43
 */
public class HwSF17 {

    /**
     * A +10  D -10
     * W +10  S -10
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 分割成数组
        String[] strArr = str.split(";");
        // A D  为x   W S 为y
        int x = 0;
        int y = 0;
        for (int i = 0; i < strArr.length; i++) {
            String s = strArr[i];
            if(s.equals("")){
                continue;
            }
            // 字母
            String first = s.substring(0, 1);
            // 数量
            String number = s.substring(1);
            if(!number.matches("[0-9]+")){
                continue;
            }

            if (first.equals("A")) {
                x = x - Integer.valueOf(number);
            } else if (first.equals("D")) {
                x = x + Integer.valueOf(number);
            } else if (first.equals("W")) {
                y = y + Integer.valueOf(number);
            } else if (first.equals("S")) {
                y = y - Integer.valueOf(number);
            }
        }
        System.out.println(x+","+y);
    }
}