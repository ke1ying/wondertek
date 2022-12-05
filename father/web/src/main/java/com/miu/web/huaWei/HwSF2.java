package com.miu.web.huaWei;

import org.apache.coyote.InputBuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author keying
 * @date 2022-08-01 09:55:11
 */
public class HwSF2 {
    /**
     * 第一行输入一个由 字母 和 数字 以及 空格组成的字符串
     * 第二行 输入一个字符
     * <p>
     * 输出该 字符 在字符串中的个数 （不区分大小写）
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(inputStreamReader);

        String all = br.readLine().toLowerCase();
        char cha = br.readLine().toLowerCase().charAt(0);

        // 循环
        char[] charAll = all.toCharArray();
        int count = 0;
        for (char c : charAll) {
            if (c == cha) {
                count ++;
            }
        }
        System.out.println(count);
       /* InputStream in = System.in;
        char cha = (char) in.read();
        Map<String, Integer> map = new HashMap<>();
        while (cha != '\n') {
            if (cha == ' ') {
                cha = (char) in.read();
                continue;
            }
            // 不包含 则直接put
            if (!map.containsKey(Character.toString(cha))) {
                map.put(Character.toString(cha), 1);
            } else {
                // 包含则新增1
                Integer old = map.get(Character.toString(cha));
                map.put(Character.toString(cha), 1 + old);
            }
            cha = (char) in.read();
        }

        // 下一行
        char xia = (char) in.read();
        System.out.println(map.get(Character.toString(xia)));*/
    }


}