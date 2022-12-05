package com.miu.web.huaWei;

import com.miu.web.controller.TransactionalCon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-08-12 18:12:56
 */
public class HwSFxxx {
    /**
     * 回文
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (getHuiWen(str)) {
            System.out.println("是的");
        } else {
            System.out.println("不是");
        }
    }

    private static boolean getHuiWen(String str) {
        Boolean returnFlag = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1-i)) {

            } else {
                returnFlag = false;
            }
        }
        return returnFlag;
    }
}