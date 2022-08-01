package com.miu.web.huaWei;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-08-01 09:55:11
 */
public class HwSF1 {
    /**
     * 计算字符串最后一个单词长度
     * 单词以空格隔开
     * 字符串长度小于5000
     * （注：字符串末尾不以空格结尾）
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
     /*   Scanner scanner = new Scanner(System.in);
        String byte1 = scanner.next();

            int num = 0;
            while (!byte1.equals("\n")) {
                if (byte1.equals(" ")) {
                    num = 0;
                } else {
                    num++;
                    num = byte1.length();
                }
                byte1 = scanner.next();
            }
            System.out.println("长度：" + num);*/

        InputStream in = System.in;
        char cha = (char) in.read();
        int num = 0;
        while (cha != '\n') {
            if (cha == ' ') {
                num = 0;
            } else {
                num ++;
            }

            cha = (char) in.read();
        }
        System.out.println(num);
    }

}