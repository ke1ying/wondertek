package com.miu.web.huaWei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-10-13 13:36:15
 */
public class HwSF43 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
            }
            // 输出
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if(map.get(str.charAt(i)) == 1){
                    System.out.println(str.charAt(i));
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("-1");
            }
        }
    }
}