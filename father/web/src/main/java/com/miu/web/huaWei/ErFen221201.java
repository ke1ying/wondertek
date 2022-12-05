package com.miu.web.huaWei;

import java.util.Arrays;

/**
 * @author keying
 * @date 2022-12-01 17:36:00
 */
public class ErFen221201 {

    /**
     * 二分查找
     *
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = new int[]{1, 10, 9, 13, 22, 5, 7, 8, 6};
        Arrays.sort(arr);
        // 起始下标 和 结束下标
        calculate(0, arr.length-1, arr, 13);
    }

    private static void calculate(int start, int end, int[] arr, int i1) {
        int mid = (end + start) / 2;
        if (arr[mid] < i1) {
            // 说明i1在右边
            calculate(mid,end,arr,i1);
        } else if (arr[mid] > i1) {
            // 说明i1 在左边
            calculate(0,mid,arr,i1);
        } else if (arr[mid] == i1) {
            System.out.println(i1);
        }
    }

}