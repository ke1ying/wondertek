package com.miu.web.controller;

public class RunableTest {
    public static void main(String[] args){
        new RunableTest().go();
    }
    public void go(){
        Runnable r=new Runnable(){
            public void run(){
                System.out.print("foo");
            }
        };
        Thread t=new Thread(r);
        t.start();
    }
}
