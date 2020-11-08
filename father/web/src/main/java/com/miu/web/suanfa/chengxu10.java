package com.miu.web.suanfa;

/*
*
* 一球从100米高度自由落下，每次落地后反跳回原高度的一半；
* 再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？*/
public class chengxu10{

    public static void main(String[] args) {
        double all = 100;
        double gong = 0;
        for (int i = 0; i < 10; i++) {
            all = all/2;
            gong += all*2;
        }
        gong = gong +100;
        System.out.println("一共:"+gong);
        System.out.println("第10此为"+all);
    }

}
