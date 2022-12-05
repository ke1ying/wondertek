package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-23 15:58:55
 */
public class HwSF57 {

    /**
     * I am a student
     * tneduts a ma I
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        List<String> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                stringBuffer.append(s.charAt(i));
            } else {
                list.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            }
        }
        list.add(stringBuffer.toString());

        // 倒叙

        for (int i = list.size() - 1; i >= 0; i--) {
            String str = fz(list.get(i));
            System.out.print(str + " ");
        }
    }

    private static String fz(String s) {
        return new StringBuffer(s).reverse().toString();
    }

}