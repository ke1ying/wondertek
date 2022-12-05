package com.miu.web.suanfa;

import java.util.Scanner;


public class chengxu10 {

    /*
*
假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半;
*
* 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double high = scanner.nextDouble();
        double temp = high/2;
        for (int i = 1; i < 5; i++) {
            high += temp *2;
            temp = temp/2;
        }
        System.out.println(high);
        System.out.println(temp);



    /*    zong += high;
        zong += (high / 2) * 2;
        zong += (high / 4) * 2;
        zong += (high / 8) * 2;
        zong += (high / 16) * 2;


        System.out.println(zong);
        double finalHigh = high / 32;
        System.out.println(finalHigh);*/
    }

}
