package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-10-13 13:36:15
 */
public class HwSF47 {

    /**
     * MP3光标位置
     * 1 、 获取当前歌曲位置  获取当前光标在4首歌哪个位置  获取总页数长度
     * 2 、 计算光标前后 有几个数
     * 3 、 通過for循环 算出前后几位是哪些值
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int songNum = Integer.valueOf(bufferedReader.readLine());
        String upDown = bufferedReader.readLine();

        int pageSize = 4;
        if (songNum < 4) {
            pageSize = songNum;
        }

        // 歌曲
        int index = 1;
        // 光标
        int pageG = 1;
        for (int i = 0; i < upDown.length(); i++) {
            if (upDown.charAt(i) == 'U') {
                if (index == 1) {
                    index = songNum;
                    pageG = pageSize;
                } else {
                    index--;
                    if (pageG != 1) {
                        pageG--;
                    }
                }
            } else if (upDown.charAt(i) == 'D') {
                if (index == songNum) {
                    index = 1;
                    pageG = 1;
                } else {
                    index++;
                    if (pageG != 4) {
                        pageG++;
                    }
                }
            }
        }

        // 计算光标前后 有几个数
        //  把前后的数拼接
        int next = pageSize - pageG;
        int pre = pageSize - next - 1;
        String page = "";
        for (int i = pre; i > 0; i--) {
            page += index - i + " ";
        }
        page += index + " ";
        for (int i = 1; i <= next; i++) {
            page += index + i + " ";
        }

        System.out.println(page);
        System.out.println(index);

    }
}