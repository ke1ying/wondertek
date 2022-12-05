package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-24 18:18:58
 */
public class HwSF65 {

    /**
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fuCount = 0;
        double db = 0.0;
        int zhengCount = 0;
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (i < 0) {
                fuCount++;
            } else if (i > 0) {
                db += Double.valueOf(i);
                zhengCount++;
            }
        }

        System.out.println(fuCount);
        BigDecimal bigDecimal = new BigDecimal(db / zhengCount);
        if (zhengCount == 0) {
            System.out.println(0.0);
        } else {
            bigDecimal = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP);
            System.out.println(bigDecimal.doubleValue());
        }
    }

}