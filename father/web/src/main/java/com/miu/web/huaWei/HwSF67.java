package com.miu.web.huaWei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-11-30 19:41:13
 */
public class HwSF67 {

    /**
     输入：
     abcd12345ed125ss123058789
     a8a72a6a5yy98y65ee1r2
     复制
     输出：
     123058789,9
     729865,2
     复制
     说明：
     样例一最长的数字子串为123058789，长度为9
     样例二最长的数字子串有72,98,65，长度都为2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String sc = "";
            String scZ = "";
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); ) {
                if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    sc += s.charAt(i);
                    i++;
                } else {
                    if (scZ.length() > sc.length()) {
                        scZ = scZ;
                    } else {
                        scZ = sc;
                    }
                    map.put(scZ, scZ.length());
                    sc = "";
                    i++;
                }
            }

            if (scZ.length() > sc.length()) {
                scZ = scZ;
            } else {
                scZ = sc;
            }
            map.put(scZ, scZ.length());

            List<String> stringList1 = new ArrayList<>();
            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> next = iterator.next();
                if (next.getValue() == scZ.length()) {
                    stringList1.add(next.getKey());
                }
            }

            // 根据下标来 排序
            String value2 = "";
            Map<Integer, String> sortMap = new TreeMap<>();
            for (int i = 0; i < stringList1.size(); i++) {
                sortMap.put(s.indexOf(stringList1.get(i)), stringList1.get(i));
            }
            Iterator<Map.Entry<Integer, String>> iteratorSort = sortMap.entrySet().iterator();
            while (iteratorSort.hasNext()) {
                Map.Entry<Integer, String> next = iteratorSort.next();
                value2 += next.getValue();
            }

            System.out.println(value2 + "," + scZ.length());

        }
    }
}