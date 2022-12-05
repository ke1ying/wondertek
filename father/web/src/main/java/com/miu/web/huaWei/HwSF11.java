package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-08-12 15:43:54
 */
public class HwSF11 {
    /**
     * 输入一个int整数
     * 将这个整数以字符串的形式逆序输出
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer st = new StringBuffer(str);
        str = st.reverse().toString();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
        }
    }
}