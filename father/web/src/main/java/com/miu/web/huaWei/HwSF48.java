package com.miu.web.huaWei;

import org.redisson.misc.Hash;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author keying
 * @date 2022-11-13 09:52:57
 */
public class HwSF48 {
    /**
     * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String sc = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            for (int j = str1.length(); j > i; j--) {
                // 如果包含，则存储
                String ls = str1.substring(i, j);
                if (str2.contains(ls)) {
                    if (ls.length() >= sc.length()) {
                        sc = ls;
                        list.add(sc);
                    }
                }
            }
        }
        // 选择小的 字符串
        str1 = str1.length() < str2.length() ? str1 : str2;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.size() == 0) {
                map.put(list.get(i), str1.indexOf(list.get(i)));
            } else {
                // 比较key长度，  比较 index
                Iterator<String> iterator = map.keySet().iterator();
                while (iterator.hasNext()){
                    String key = iterator.next();
                    //  比较key长度
                    if(key.length() == list.get(i).length()){
                        if(map.get(key) > str1.indexOf(list.get(i))){
                            iterator.remove();
                            map.put(list.get(i), str1.indexOf(list.get(i)));
                        }
                    }else if(key.length() < list.get(i).length()){
                        iterator.remove();
                        map.put(list.get(i), str1.indexOf(list.get(i)));
                    }
                }
            }
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

     }
}