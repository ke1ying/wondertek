package com.miu.web.suanfa;

import java.util.Scanner;

public class chengXu31 {
    /*
    * 将一个数组逆序输出。
     * */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] a=new int[3];
        int i=0;
        do {
            a[i]=input.nextInt();
            i++;
        }while(a[i-1]!=-1);
        for(int j=0;j<i-1;j++) {
            System.out.println(a[j]);
        }
        for(int k=i-1;k>0;k--) {
            System.out.println(a[k-1]);
        }

    }
}
