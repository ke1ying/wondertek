package com.miu.web.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
* 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
输出描述:
输出输入字符串中含有该字符的个数。
* */
public class HuaWeiSuanFa2 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader bf = new BufferedReader(isr);
        String all = bf.readLine();
        char c = bf.readLine().charAt(0);
        char[] chars = all.toCharArray();
        int count = 0;
        for (char cc : chars) {
            if (cc == c || cc + 32 == c || cc - 32 == c) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
