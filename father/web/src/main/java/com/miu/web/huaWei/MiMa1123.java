package com.miu.web.huaWei;

import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-23 15:13:11
 */
public class MiMa1123 {

    /**
     * /**
     * * 021Abc9Abc1
     * * 1.长度超过8位
     * * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            // 长度超过8位
            if (!length(str)) {
                System.out.println("NG");
                continue;
            }

            // 包括大小写字母.数字.其它符号,以上四种至少三种
            if (!numABC(str)) {
                System.out.println("NG");
                continue;
            }

            // 不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
            if (!gong(str)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean gong(String str) {
        // 截取长度2 挨个比较
        int start = 0;
        int end = 3;
        while (end <= str.length() - 1) {
            String jieQ = str.substring(start,end);
            String qian = str.substring(0,start);
            String hou = str.substring(end,str.length()-1);
            if(qian.contains(jieQ) || hou.contains(jieQ)){
                return false;
            }
            start++;
            end++;
        }

        return true;
    }

    private static boolean numABC(String str) {
        int num = 0;
        int numA = 0;
        int numa = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                numA = 1;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                numa = 1;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num = 1;
            } else {
                other = 1;
            }
        }
        if (num + numA + numa + other < 3) {
            return false;
        }
        return true;
    }

    private static boolean length(String str) {
        if (str.length() <= 8) {
            return false;
        }
        return true;
    }

}