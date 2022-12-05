package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-10-13 10:12:44
 */
public class HwSF38 {

    /**
     * 1 -1
     * 2 -1
     *
     * 3 2
     * 4 3
     * 5 2
     * 6 4
     *
     * 7 2
     * 8 3
     * 9 2
     * 10 4
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
           Integer integer = sc.nextInt();
            if(integer == 1 || integer == 2){
                System.out.println("-1");
                return;
            }
            if(integer % 4 == 3 || integer % 4 == 1){
                System.out.println("2");
                return;
            }
            if(integer % 4 == 0){
                System.out.println("3");
                return;
            }
            if(integer % 4 == 2){
                System.out.println("4");
                return;
            }
        }
    }
}