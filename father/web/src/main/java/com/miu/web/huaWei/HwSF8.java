package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-08-11 10:57:31
 */
public class HwSF8 {
    /**
     * 先输入键值对的个数n（1 <= n <= 500）
     * 接下来n行每行输入成对的index和value值，以空格间隔
     * 输入
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     *
     * 输出合并后的键值对（多行）
     * 输出：
     * 0 3
     * 1 2
     * 3 4
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer first = Integer.valueOf(str);
        HashMap<Integer,Integer> map = new HashMap<>();
        List list = new ArrayList();
        for (int i = 0; i < first; i++) {
            String str1 = br.readLine();
            String arr[] = str1.split(" ");

            Integer s1 = Integer.valueOf(arr[0]);
            String s2 = arr[1];
            if(map.containsKey(s1)){
                Integer oldValue = map.get(s1);
                map.put(s1,Integer.valueOf(s2) + oldValue);
            }else{
                map.put(s1,Integer.valueOf(s2));
                list.add(s1);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " +map.get(list.get(i)));
        }

    }
}