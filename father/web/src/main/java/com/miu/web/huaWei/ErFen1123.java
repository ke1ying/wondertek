package com.miu.web.huaWei;

import java.util.Arrays;

/**
 * @author keying
 * @date 2022-11-23 09:25:45
 */
public class ErFen1123 {

    /**
     * 二分查找法解题思路
     * 每次从数组的中间，比较 需要找的 值，如果小于中位数，则在数组前一半找，如果大于，则在数组后一半找
     * <p>
     * * 1、首先二分查找法需要先排序
     * * 2、所以 传参是开始下标，结束下标，数组
     * * 3、必须先用首尾下标 计算出他的 中点下标
     * * 4、计算是否 大于中位数 或者 小于 中位数，执行 mid +1 或者 mid -1
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 4, 5, 3, 1,6,9,32};
        Arrays.sort(arr);
        int startIndex = 0;
        int endIndex = arr.length - 1;
        find(startIndex, endIndex, arr, 3);
    }

    private static void find(int startIndex, int endIndex, int[] arr, int a) {
        int mid = (endIndex + startIndex) / 2;
        if (arr[mid] < a) {
            find(mid+1,endIndex,arr,a);
        } else if (arr[mid] > a) {
            find(startIndex,mid-1,arr,a);
        }else{
            System.out.println(a);
        }
    }

}