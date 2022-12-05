package com.miu.web.huaWei;

import java.util.Scanner;

/**
 * @author keying
 * @date 2022-10-13 13:36:15
 */
public class HwSF45 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Integer integer = scanner.nextInt();
            String s = Integer.toBinaryString(integer);
            String s2 = s.replace("1","");
            System.out.println(s.length() - s2.length());
        }
    }



}