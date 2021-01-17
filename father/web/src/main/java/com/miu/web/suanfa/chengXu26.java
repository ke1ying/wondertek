package com.miu.web.suanfa;

public class chengXu26 {
    /*
        求100之内的素数:只能被1和本身整除
    */

    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 3; i < 100; i += 2) {
            System.out.println("sqrt:" + Math.sqrt(i));
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag == true)
                System.out.println(i);
        }
//        System.out.println(Math.sqrt(3.0));
       /* for (int i = 2; i < 100; i++) {
            for (int j = 1; j < (i/2); j++) {
                if(i%j == 0){
                    System.out.print(i+",");
                }
            }
        }*/
    }


}
