package com.miu.web.suanfa;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o2+"和"+o1+"比较："+o2.compareTo(o1));
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);
    }
}
