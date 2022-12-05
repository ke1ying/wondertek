package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF30 {
    /**
     * 分别输出第5次落地时，共经过多少米以及第5次反弹多高
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        double z = Integer.valueOf(str);
        double total = z / 32;

        double five = (z / 16) * 2;
        double four = (z / 8) * 2;
        double three = (z / 4) * 2;
        double two = (z / 2) * 2;

        System.out.println(z + five + four + three + two);
        System.out.println(total);
    }

}