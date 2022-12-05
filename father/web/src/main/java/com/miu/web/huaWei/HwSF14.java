package com.miu.web.huaWei;

import javax.xml.soap.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author keying
 * @date 2022-08-12 15:43:54
 */
public class HwSF14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer first = Integer.valueOf(br.readLine());
        String[] arr = new String[first];
        for (int i = 0; i < first; i++) {
            String str = br.readLine();
            arr[i] = str;
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}