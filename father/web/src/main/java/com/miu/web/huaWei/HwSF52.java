package com.miu.web.huaWei;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-17 11:30:45
 */
public class HwSF52 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int[] month_day = {31,28,31,30,31,30,31,31,30,31,30,31};
            int sum = 0;
            for(int i = 0; i < month - 1; i++){
                sum += month_day[i];
            }
            sum += day;
            // 闰年 二月多加一天
            if(month > 2 && is_leap(year)){
                sum += 1;
            }
            System.out.println(sum);
        }
    }

    public static boolean is_leap(int n){
        if(n % 4 == 0 && n % 100 != 0 || n % 400 == 0){
            return true;
        }else{
            return false;
        }
    }

}