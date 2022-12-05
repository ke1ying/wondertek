package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-08-08 15:52:51
 */
public class HwSF5 {
    /**
     * 输入一个十六进制的数值字符串。
     * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.substring(2,str.length());
        System.out.println(Integer.parseInt(str,16));

    }

}