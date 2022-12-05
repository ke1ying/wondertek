package com.miu.web.huaWei;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keying
 * @date 2022-08-12 15:43:54
 */
public class HwSF16 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < first.length(); i++) {
            if(first.charAt(i) != ' '){
                sb.append(first.charAt(i));
            }else{
                sb = new StringBuffer();
            }
        }
        

    }

}