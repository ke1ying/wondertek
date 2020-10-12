package com.miu.web.suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class chengXu6 {
    /*题目：输入两个正整数m和n，求其最大公约数和最小公倍数。     */
    public static void main(String[] args) {
        int m = 11, n = 23;
        int z = 2;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (m >= z) {
            if (m % z == 0 && n % z == 0) {
                m = m / z;
                n = n / z;
                list1.add(z);
            } else {
                z++;
            }
        }
        System.out.println(list1);
        if(list1.size()>0){
            System.out.println("最大公约数:" + list1.get(0) * list1.get(1));
            System.out.println("最小公倍数:" + list1.get(0) * list1.get(1) * m * n);
        }else{
            System.out.println("没有最大公约数");
            System.out.println("最小公倍数:" + m * n);
        }

    }
}
