package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF23 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                    list.add(str.charAt(i));
                } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    list.add(str.charAt(i));
                }
            }
        }

        //排序
        list = list.stream().sorted(Comparator.comparing(Character::toUpperCase)).collect(Collectors.toList());

        int z = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                    System.out.print(list.get(z));
                    z++;
                } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    System.out.print(list.get(z));
                    z++;
                }else{
                    System.out.print(str.charAt(i));
                }
            }else{
                System.out.print(" ");
            }
        }
    }

}