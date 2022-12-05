package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF22 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 隔开
        List<Integer> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                list.add(Integer.valueOf(sb.toString()));
                sb = new StringBuffer();
            }else{
                sb.append(str.charAt(i));
            }
        }
        list.add(Integer.valueOf(sb.toString()));

        // list从中间往旁边依次递减
        System.out.println(list);

    }

}