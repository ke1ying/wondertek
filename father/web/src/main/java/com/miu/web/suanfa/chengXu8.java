package com.miu.web.suanfa;

import java.util.Scanner;

public class chengXu8 {
    /*求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
    例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。*/
    public static void main(String[] args) {
       Scanner sc1 = new Scanner(System.in);
       Scanner sc2 = new Scanner(System.in);
       String a = sc1.nextLine();
       Integer intA = Integer.valueOf(a);
       String b = sc2.nextLine();
       int z = 0;
       int sum = 0;
        for (int i = 0; i < b.length() ; i++) {
            z += intA;
            sum += z;
            intA = 10*intA;
        }
        System.out.println(sum);
    }
}
