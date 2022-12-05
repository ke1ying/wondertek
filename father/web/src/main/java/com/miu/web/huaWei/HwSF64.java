package com.miu.web.huaWei;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-11-24 18:18:58
 */
public class HwSF64 {

    /**
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            double zheng = 0.0;
            Integer zhengNum = 0;
            List<Integer> fu = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                int shu = scanner.nextInt();
                if (shu > 0) {
                    zheng += shu;
                    zhengNum++;
                } else if (shu < 0) {
                    fu.add(shu);
                }
            }
            // zheng平均值
            double avg = 0.0;
            if (zhengNum != 0) {
                avg = zheng / zhengNum;
            }
            BigDecimal bigDecimal = new BigDecimal(avg);
            double z = bigDecimal.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();

            System.out.print(fu.size() + " " + z);

        }
    }

}