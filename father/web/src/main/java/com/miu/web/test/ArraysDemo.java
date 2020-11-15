package com.miu.web.test;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        Integer [] arrA = new Integer[]{123,234,666,432};
        Integer [] arrB = new Integer[]{888,888,888,888};
        try{
            System.arraycopy(arrA,1,arrB,0,3);
        }catch (Exception e){
            System.out.println("转换异常："+e.getMessage());
        }
        for (int i = 0; i < arrB.length; i++) {
            System.out.println(arrB[i]);
        }

        System.out.println("Arrays的copyOf:");

        Integer [] arrD = Arrays.copyOf(arrA,3);
        for (int i = 0; i < arrD.length; i++) {
            System.out.println(arrD[i]);
        }

        System.out.println("Arrays的copyOfRange:");
        Integer [] arrE = Arrays.copyOfRange(arrA,1,2);
        for (int i = 0; i < arrE.length; i++) {
            System.out.println(arrE[i]);
        }
    }
}
