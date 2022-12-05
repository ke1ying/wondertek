package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-08-08 15:29:53
 */
public class HwSF4 {

    /**
     * 连续输入字符串(每个字符串长度小于等于100)
     * 依次输出所有分割后的长度为8的新字符串
     * <p>
     * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
      /*  Scanner sc = new Scanner(System.in);
        String str;
        while (sc.hasNext()) {
            str = sc.nextLine();
            while(str.length()>8){
                System.out.println(str.substring(0,8));
                str = str.substring(8);
            }
            str = str + "00000000";
            System.out.println(str.substring(0,8));
        }*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(str.length()>8){
            System.out.println(str.substring(0,8));
            str = str.substring(8);
        }
        str = str + "00000000";
        System.out.println(str.substring(0,8));
    }
}