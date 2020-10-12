package com.miu.web.suanfa;

import java.util.ArrayList;
import java.util.List;

public class day4 {
    /*
    * 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，
    * 其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "，
    * 因为153=1的三次方＋5的三次方＋3的三次方。
    * */

    public static void main(String[] args) {
/*        371*/
        List<Integer> list = new ArrayList<>();
        for (int i = 100; i < 1000; i++) {
            int a,b,c;
            a = i/100;
            b = i%100/10;
            c = i%10;
            if((a*a*a+b*b*b+c*c*c) == i){
                list.add(i);
            }
        }
        System.out.println(list);
    }
}
