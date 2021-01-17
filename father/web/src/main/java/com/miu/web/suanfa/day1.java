package com.miu.web.suanfa;

public class day1 {

    /*
     *
     *   下标 0  1   2   3   4   5   6  7  8  9   10
     *   月份 1  2   3   4   5   6   7  8  9  10  11  12  13   14  15  16  17  18  19  20
     *   几对 1  1   2   3   5   8  13  21 34  55  89
     *   几只 2  2   4   6
     *
     *            f1    f2    f3
     *       0     1     1     0
     *       1     0     1     1
     *       2     1     0     1
     *       3     1     1     2
     *       4     2     1     3
     *       5     3     2     5
     *       6     5     3     8
     *古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到
     * 第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * */
    public static void main(String[] args) {
        int a=1,b=1,c=0;
        for (int i = 0; i < 10; i++) {
            b = a;
            a = c;
            c = a+b;
        }
        System.out.println(c);










      /*  Integer f1 = 1,f2 = 1,f3 = 0;
        for (int i = 0; i < 10; i++) {
            f2 = f1;
            f1 = f3;
            f3 = f1 + f2;
        }
        System.out.println(f3);*/
    }

}

