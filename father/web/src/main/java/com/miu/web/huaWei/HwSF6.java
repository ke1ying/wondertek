package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-08-08 16:07:20
 */
public class HwSF6 {
    /**
     * 输入一个整数
     * <p>
     * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.valueOf(str);
        diGui(num);
    }

    private static void diGui(int num) {
        for (int i = 2; i*i <= num; i++) {
            if(num % i == 0){
                System.out.println(i);
                diGui(num / i);
                break;
            }
        }

    }
   /* public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long num = Long.parseLong(scan.next());
        getPrimer(num);
    }

    public static void getPrimer(long num){
        for (int i= 2;i <= num; i++){
            if (num % i==0){
                System.out.print(i + " ");
                getPrimer(num/i);
                break;
            }
        }
    }*/
}