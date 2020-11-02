package com.miu.web.suanfa;

import java.io.IOException;
import java.io.InputStream;

/*
* 计算字符串最后一个单词的长度，单词以空格隔开。
* 如：输入 hel hello word
* 输出为4
* */
public class HuaWeiSuanFa1 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        char c = (char)in.read();
        Integer num = 0;
        while(c != '\n'){
            if(c == ' '){
                num = 0;
            }else{
                num ++;
            }
            c = (char)in.read();
        }
        System.out.println(num);
    }

}
