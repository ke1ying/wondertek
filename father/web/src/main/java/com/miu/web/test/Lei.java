package com.miu.web.test;

import java.util.Properties;

public class Lei extends FuLei{
    int zz = 10;
   void staticThread(){
       int zz =5;
       this.zz = zz;
       System.out.println("类类静态方法");
   }
    static {
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类非静态代码块");
    }

    public Lei(){
       System.out.println("子类构造函数");
    }

    public static void main(String[] args) {


    }
}
