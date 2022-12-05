package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author keying
 * @date 2022-08-13 19:17:02
 */
public class ErFen3 {

    /**
     * 二分查找法接题思路
     * 每次从数组的中间，比较 需要找的 值，如果小于中位数，则在数组前一半找，如果大于，则在数组后一半找
     * <p>
     * 1、首先二分查找法需要先排序
     * 2、所以 传参是开始下标，结束下标，数组
     * 3、必须先用首尾下标 计算出他的 中点下标
     * 4、计算是否 大于中位数 或者 小于 中位数，执行 mid +1 或者 mid -1
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String findStr = br.readLine();
        Integer arr[] = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.valueOf(str.charAt(i));
        }
        Arrays.sort(arr);
        // 开始查找
        Integer index = getErFen(arr, Integer.valueOf(findStr.charAt(0)), 0, arr.length - 1);
        System.out.println(index);

        System.out.println();
    }

    private static Integer getErFen(Integer[] arr, Integer findStr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == findStr) {
                return findStr;
            } else if (arr[mid] < findStr) {
                start = 1 + mid;
            } else if (arr[mid] > findStr) {
                end = mid - 1;
            }
        }

        return -1;
    }
}