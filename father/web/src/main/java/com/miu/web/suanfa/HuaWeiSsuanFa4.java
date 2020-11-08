package com.miu.web.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuaWeiSsuanFa4 {
    /*
    输入两个十六进制，用\n隔开
    * 0xA
        0xAA
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = bf.readLine())!=null){
            String temp = input.substring(2,input.length());
            int sum = 0;
            int length = temp.length();
            for(int i= length-1;i>=0;i--){
                char c = temp.charAt(i);
                int tempNum = (int)c;
                if(tempNum>=65){
                    tempNum = tempNum - 65 + 10;
                }else{
                    tempNum = tempNum - 48;
                }
                sum = sum + (int) Math.pow(16, length-i-1)*tempNum;
            }
            System.out.println(sum);
        }
    }
}
