package com.miu.web.huaWei;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-10-13 13:36:15
 */
public class HwSF42 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            Integer length = scanner.nextInt();
            Integer index = scanner.nextInt();

            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                Integer num = scanner.nextInt();
                integerList.add(num);
            }

            integerList = integerList.stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < index; i++) {
                System.out.print(integerList.get(i)+" ");
            }
        }
    }
}