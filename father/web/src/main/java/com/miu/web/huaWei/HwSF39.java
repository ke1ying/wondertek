package com.miu.web.huaWei;

import java.util.Scanner;

/**
 * @author keying
 * @date 2022-10-13 10:12:44
 */
public class HwSF39 {

    /**
     * @param args
     */
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Integer integer = scanner.nextInt();
            int count = 0;
            for (int i = 1; i <= integer; i++) {
                if (String.valueOf(i).contains("7")) {
                    count++;
                    continue;
                }
                if (i % 7 == 0) {
                    count++;
                    continue;
                }
            }
            System.out.println(count);
        }
    }
}