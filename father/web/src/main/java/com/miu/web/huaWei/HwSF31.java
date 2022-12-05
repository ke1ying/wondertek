package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author keying
 * @date 2022-09-02 16:08:46
 */
public class HwSF31 {

    /**
     * 假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
     * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer z = Integer.valueOf(str);
        int first = 0;
        int second = 1;
        if(z == 1){
            System.out.println(1);
        }else{
            for (int i = 1; i < z; i++) {
                int temp = 0;
                temp = second;
                second = first + second;
                first =temp;
            }
        }
        System.out.println(second);

    }
}