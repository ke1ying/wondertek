package com.miu.web.test;

public class Bground extends Thread{


    public static void main(String[] args) {
        Bground b = new Bground();
        b.start();
    }

    @Override
    public void start() {
        super.start();
    }
}
