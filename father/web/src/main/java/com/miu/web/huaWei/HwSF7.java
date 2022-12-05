package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-08-09 19:16:33
 */
public class HwSF7 {
    /**
     * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
     * 如果小数点后数值大于等于 0.5 ,
     * 向上取整；小于 0.5 ，则向下取整
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String arr[] = str.split("\\.");
        String end = "0." + arr[1];
        Double endInt = Double.valueOf(end);
        double i = 0.5;
        if (endInt >= i) {
            System.out.println(Integer.valueOf(arr[0]) + 1);
        } else {
            System.out.println(Integer.valueOf(arr[0]));
        }

    }
}