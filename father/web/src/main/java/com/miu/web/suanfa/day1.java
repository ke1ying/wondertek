package com.miu.web.suanfa;

import java.util.*;

public class day1 {

    /*
     * 输如：人名（用“,”隔开，代表投票数，输出活得票数最多的人，若票数相同比较人名大小）
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] strings = str.split(",");
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arrayList.add(strings[i]);
        }
        String result = suanfa(arrayList);
        System.out.println(result);
    }

    private static String suanfa(ArrayList<String> arrayList) {
        Map<String, Integer> resu = new TreeMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
           /* System.out.println("charAt(0):" + arrayList.get(i).charAt(0));
            if (arrayList.get(i).charAt(0) < 'A' || arrayList.get(i).charAt(0) > 'Z') {
                return "错误1";
            }
            for (int j = 0; j < arrayList.get(i).length(); j++) {
                System.out.println("charAt(j):" + arrayList.get(i).charAt(j));
                if (arrayList.get(i).charAt(j) < 'a' || arrayList.get(i).charAt(j) > 'z') {
                    return "错误2";
                }
            }*/
            if (resu.containsKey(arrayList.get(i))) {
                int temp = resu.get(arrayList.get(i));
                temp++;
                resu.put(arrayList.get(i), temp);
            } else {
                resu.put(arrayList.get(i), 1);
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(resu.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                System.out.println("o1.getValue():" + o1.getValue());
                System.out.println("o2.getValue():" + o2.getValue());
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    System.out.println("o1.getKey():" + o1.getKey());
                    System.out.println("o2.getKey():" + o2.getKey());
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
        String result = list.get(0).getKey();
        return result;
    }

}

