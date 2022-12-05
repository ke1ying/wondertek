package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF21 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<String, Integer> hashMap = new HashMap();
       /* for (int i = 0; i < str.length(); i++) {
            if (!hashMap.containsKey(String.valueOf(str.charAt(i)))) {
                hashMap.put(String.valueOf(str.charAt(i)), 1);
            } else {
                Integer old = hashMap.get(String.valueOf(str.charAt(i)));
                hashMap.put(String.valueOf(str.charAt(i)), old + 1);
            }
        }*/

        for (int i = 0; i < str.length(); i++) {
            hashMap.put(String.valueOf(str.charAt(i)),
                    hashMap.getOrDefault(String.valueOf(str.charAt(i)),0) + 1);
        }
    /*    List<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> map : hashMap.entrySet()) {
            list.add(map.getValue());
        }
        // 排序
        list = list.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());*/

        Collection<Integer> valueList = hashMap.values();
        int min = Collections.min(valueList);

        // 去掉
        List<String> deleteList = new ArrayList<>();
        for (Map.Entry<String, Integer> map : hashMap.entrySet()) {
            if (String.valueOf(min).equals(map.getValue().toString())) {
                str = str.replace(map.getKey(), "");
            }
        }
        System.out.println(str);
    }

}