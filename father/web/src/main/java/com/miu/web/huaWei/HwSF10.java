package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @author keying
 * @date 2022-08-11 11:32:43
 */
public class HwSF10 {

    /**
     * 输入一行没有空格的字符串。
     * <p>
     * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<Character> set = new HashSet<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(set.add(c)){
                stringBuffer.append(c);
            }
        }
        System.out.println(stringBuffer.toString().length());
    }

}