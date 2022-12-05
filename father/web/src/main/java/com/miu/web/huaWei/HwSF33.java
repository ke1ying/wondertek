package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-09-02 17:06:40
 */
public class HwSF33 {
    /**
     * 统计其中英文字符，空格字符，数字字符，其他字符的个数
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int englishNum = 0;
        int spaceNum = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) <= 'z' && str.charAt(i) >= 'a'){
                englishNum++;
            } else if(str.charAt(i) <= 'Z' && str.charAt(i) >= 'A'){
                englishNum++;
            } else if(str.charAt(i) == ' ' ){
                spaceNum++;
            } else if(str.charAt(i) <= '9' && str.charAt(i) >= '0'){
                num++;
            } else{
                other++;
            }
        }
        System.out.println(englishNum);
        System.out.println(spaceNum);
        System.out.println(num);
        System.out.println(other);
    }
}