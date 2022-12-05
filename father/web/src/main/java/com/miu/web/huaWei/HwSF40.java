package com.miu.web.huaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-10-13 10:12:44
 */
public class HwSF40 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            int count = 0;
            for (int j = 1; j <= i; j++) {
                // 统计可以除的数
                List<Integer> add = new ArrayList<>();
                for (int k = 1; k < j; k++) {
                    if (j % k == 0) {
                        add.add(k);
                    }
                }
                int sum = 0;
                for (int k = 0; k < add.size(); k++) {
                    sum += add.get(k);
                }
                if(sum == j){
                    count++;
                    continue;
                }
            }
            System.out.println(count);
        }
    }
}