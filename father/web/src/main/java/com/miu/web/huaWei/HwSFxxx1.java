package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keying
 * @date 2022-08-12 18:12:56
 */
public class HwSFxxx1 {
    /**
     * 冒泡
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Integer [] arr = {8,7,10,5};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp;
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    System.out.println("!");
                }
            }
        }
        System.out.println(arr);
    }

}