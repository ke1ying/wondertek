package com.miu.web.huaWei;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author keying
 * @date 2022-08-11 11:20:40
 */
public class HwSF9 {
    /**
     * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 保证输入的整数最后一位不是 0 。
     * @param args
     */
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = br.readLine();
        str = new StringBuffer(str).reverse().toString();
        //去重
       // List list = new ArrayList();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            /*if(!list.contains(c)){
                System.out.print(c);
                list.add(c);
            }*/
            if(hashSet.add(c)){
                System.out.print(c);
            }

        }

    }
}