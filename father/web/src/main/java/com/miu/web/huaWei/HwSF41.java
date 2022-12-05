package com.miu.web.huaWei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-10-13 13:36:15
 */
public class HwSF41 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            BigInteger a = in.nextBigInteger();
            BigInteger b = in.nextBigInteger();
//            BigInteger c = new BigInteger(a);
//            BigInteger d = new BigInteger(b);
            System.out.println(a.add(b));
        }
    }
}