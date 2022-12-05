package com.miu.web.huaWei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-11-17 11:30:45
 */
public class HwSF54 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();
        String string = Integer.toBinaryString(num);
        List<Integer> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '1'){
                stringBuffer.append("1");
            }else{
                list.add(stringBuffer.toString().length());
                stringBuffer = new StringBuffer();
            }
        }
        list.add(stringBuffer.toString().length());
        list = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list.get(list.size()-1));

    }

}