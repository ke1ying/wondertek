package com.miu.web.huaWei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-09-09 15:29:22
 */
public class HwSF35 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Integer i = sc.nextInt();

            for (int j = 0; j < i; j++) {
                String s1 = sc.next();
                int s[] = new int[128];
                for (int j1 = 0; j1 < s1.length(); j1++) {
                    s[s1.charAt(j1)]++;
                }
                Arrays.sort(s);
                int sun = 0;
                int cheng = 26;
                for (int k = s.length-1; k > 0; k--) {
                    sun = sun + cheng*s[k];
                    cheng--;
                }
                System.out.println(sun);
            }

        }
    }

}