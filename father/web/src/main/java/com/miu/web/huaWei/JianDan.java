package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keying
 * @date 2022-09-05 15:33:23
 */
public class JianDan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tr = br.readLine();
      //  List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tr.length(); i++) {
            if(tr.charAt(i) == ' '){
               // list.add(sb.toString());
                sb = new StringBuffer();
            }else{
                sb.append(tr.charAt(i));
            }
        }

        System.out.println(sb.toString().length());
    }
}