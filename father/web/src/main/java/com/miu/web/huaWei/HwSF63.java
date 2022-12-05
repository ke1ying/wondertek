package com.miu.web.huaWei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-11-24 18:18:58
 */
public class HwSF63 {

    /**
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Integer num = scanner.nextInt();
            List<Integer> sortList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                int shu = scanner.nextInt();
                sortList.add(shu);
            }
            // 排序
            if (scanner.nextInt() == 0) {
                // 升序
                sortList = sortList.stream().sorted().collect(Collectors.toList());
            } else {
                // 降序
                sortList = sortList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            }

            for (Integer integer : sortList) {
                System.out.print(integer + " ");
            }
        }

    }

}