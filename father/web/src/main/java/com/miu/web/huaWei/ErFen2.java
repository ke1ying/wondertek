package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-08-13 19:17:02
 */
public class ErFen2 {

    /**
     * 二分查找法接题思路
     * 每次从数组的中间，比较 需要找的 值，如果小于中位数，则在数组前一半找，如果大于，则在数组后一半找
     *
     * 1、所以需要写个递归 传参是开始下标，结束下标，数组
     * 2、必须先用首尾下标 计算出他的 中点下标
     * 3、计算是否
     * @param args
     */
   /* public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String findStr = br.readLine();
        Integer arr[] = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.valueOf(str.charAt(i));
        }

        // 开始查找
        System.out.println(getErFen(arr,Integer.valueOf(findStr.charAt(0)),0,arr.length-1));
    }

    private static Integer getErFen(Integer[] arr,Integer findStr, int start, int end) {
        int mid = (start + end)/2;
        if(arr[mid] == findStr){
            return mid;
        }else if(arr[mid] < findStr){
            start = 1 + mid;
            getErFen(arr,findStr,start,end);
        }else if(arr[mid] > findStr){
            end = mid - 1;
            getErFen(arr,findStr,start,end);
        }
        return mid;
    }*/
}