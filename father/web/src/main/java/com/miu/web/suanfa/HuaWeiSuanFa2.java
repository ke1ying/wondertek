package com.miu.web.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
输出描述:
输出输入字符串中含有该字符的个数。
* */
public class HuaWeiSuanFa2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String strs = br.readLine();
        char c = br.readLine().charAt(0);
        char[] chars = strs.toCharArray();
        int total = 0;
        for (char ch : chars) {
            if(ch == c || ch +32 == c || ch - 32 == c){
                total++;
            }
        }
        System.out.println(total);
    }


}
