package com.miu.web.huaWei;

import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF25 {


    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        int z = 0;
        while(sc.hasNext()){
            String str = sc.next();
            if(z == 0){
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) >= '0' && str.charAt(i) <= '8') {
                        sb.append((char)(str.charAt(i) + 1));
                    } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Y') {
                        sb.append((char)(str.charAt(i) + 32+1));
                    } else if(str.charAt(i) >= 'b' && str.charAt(i) <= 'z') {
                        sb.append((char)(str.charAt(i) - 32+1));
                    }else if (str.charAt(i) == 'Z') {
                        sb.append("a");
                    } else if (str.charAt(i) == 'a') {
                        sb.append("B");
                    }else if (str.charAt(i) == '9') {
                        sb.append("0");
                    }
                }
                z ++;
            }else{
                // 解密
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) >= '1' && str.charAt(i) <= '9') {
                        sb.append((char)(str.charAt(i) - 1));
                    } else if (str.charAt(i) >= 'B' && str.charAt(i) <= 'Y') {
                        sb.append((char)(str.charAt(i) + 32-1));
                    } else if(str.charAt(i) >= 'b' && str.charAt(i) <= 'z') {
                        sb.append((char)(str.charAt(i) - 32-1));
                    }else if (str.charAt(i) == 'Z') {
                        sb.append("y");
                    } else if (str.charAt(i) == 'a') {
                        sb.append("Z");
                    }else if (str.charAt(i) == '0') {
                        sb.append("9");
                    }else if (str.charAt(i) == 'A') {
                        sb.append("z");
                    }
                }
            }
            System.out.println(sb.toString());
            sb = new StringBuffer();
        }



    }

}