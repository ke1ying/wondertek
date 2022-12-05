package com.miu.web.huaWei;

import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-17 11:02:08
 */
public class HwSF51 {

    /**
     * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
     * 现要求你打印出所有花一百元买一百只鸡的方式。
     *
     * man  5
     * woman 3
     * 3 little  1   little 1/3
     *
     * 100元打印100只鸡的方式
     *
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 买x鸡翁，y只鸡母，z只鸡雏
        //5x+3y+z/3=100  ==>  15x + 9y + z = 300
        //x+y+z==100确定
        // ==>   14x + 8y = 200  ==> 7x + 4y = 100  ==>  y = (100 - 7x)/4
        while (in.hasNextInt()){
            int n = in.nextInt();
            // 整数买鸡
            for (int i = 0; i <= 14; i++) {
                // 整除
                if((100-7*i) %4 == 0){
                    int y = (100-7*i)/4;
                    int z = 100 -i - y;
                    System.out.println(i +" " + y+" " +z);
                }
            }
        }
    }

}