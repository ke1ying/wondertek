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
public class HwSF28 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<Integer> num = new ArrayList<>();
        List<String> da = new ArrayList<>();
        List<String> xiao = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                xiao.add(String.valueOf(str.charAt(i)));
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num.add(Integer.valueOf(String.valueOf(str.charAt(i))));
            }
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                da.add(String.valueOf(str.charAt(i)));
            }
        }

        num = num.stream().sorted(Comparator.comparing(Integer::valueOf)).collect(Collectors.toList());
        da = da.stream().sorted(Comparator.comparing(String::valueOf)).collect(Collectors.toList());
        xiao = xiao.stream().sorted(Comparator.comparing(String::valueOf)).collect(Collectors.toList());
        for (int i = 0; i < num.size(); i++) {
            System.out.print(num.get(i));
        }
        for (int i = 0; i < da.size(); i++) {
            System.out.print(da.get(i));
        }
        for (int i = 0; i < xiao.size(); i++) {
            System.out.print(xiao.get(i));
        }
    }

}