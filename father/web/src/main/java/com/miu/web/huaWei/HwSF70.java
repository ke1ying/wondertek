package com.miu.web.huaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-12-06 21:04:35
 */
public class HwSF70 {
    /**
     * 输入：
     * 3
     * 1 2 5
     * 4
     * -1 0 3 2
     * <p>
     * 输出：
     * -101235
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            Integer[] arr = new Integer[num];
            for (int i = 0; i < num; i++) {
                int ls = sc.nextInt();
                arr[i] = ls;
            }

            int num2 = sc.nextInt();
            // 放入第二组
            Integer[] arr2 = new Integer[num + num2];
            for (int i = 0; i < num2; i++) {
                arr2[i] = sc.nextInt();
            }

            // 第一组放入第二组
            for (int i = 0; i < num; i++) {
                arr2[num2] = arr[i];
                num2++;
            }

            Arrays.sort(arr2);
            List<Integer> list = Arrays.asList(arr2);
            List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                System.out.print(collect.get(i));
            }

        }
    }
}