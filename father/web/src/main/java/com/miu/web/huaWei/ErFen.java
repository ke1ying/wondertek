package com.miu.web.huaWei;

import com.sun.deploy.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author keying
 * @date 2022-08-11 08:29:29
 */
public class ErFen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer in = Integer.valueOf(str);

        Integer[] arr = {1, 2, 3, 9, 5, 6, 7, 10};
        Arrays.sort(arr);

        // 中间index
        int z = getIndex(arr, in, 0, arr.length);
        System.out.println(z);

    }

    private static Integer getIndex(Integer[] arr, Integer in, Integer start, Integer end) {

        while (start <= end) {
            int index = (start + end) / 2;
            if(arr[index] == in){
                return in;
            }

            if(arr[index] < in){
                start = index + 1;
            }

            if(arr[index] > in){
                end = index - 1;
            }
        }
        return 0;
    }


}