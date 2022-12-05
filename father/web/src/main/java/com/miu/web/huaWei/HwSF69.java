package com.miu.web.huaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-12-01 17:07:33
 */
public class HwSF69 {
    /**
     * 6
     * 2 5 1 5 4 5
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                int i1 = scanner.nextInt();
                integerList.add(i1);
            }

            // 分别计算走几步
            int sc = 0;
            for (int i = 0; i < integerList.size(); i++) {
                int bu = 0;
                for (int i1 = i; i1 < integerList.size(); i1++) {
                    /*if (integerList.get(i) < integerList.get(i1)) {
                        bu++;
                    }*/
                    // 统计 大于integerList.get(i) ，并且是按顺序 排序的 个数
                    List<Integer> daList = new ArrayList<>();
                    if (integerList.get(i) < integerList.get(i1)) {
                        daList.add(integerList.get(i1));
                    }
                    int z = 0;
                    for (int j = 0; j < daList.size(); j++) {
                        z = daList.get(j);

                    }
                }
                sc = sc < bu ? bu : sc;
            }
            System.out.println(sc);
        }
    }
}