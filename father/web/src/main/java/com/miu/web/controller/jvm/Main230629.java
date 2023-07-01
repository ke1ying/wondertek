package com.miu.web.controller.jvm;

/**
 * @author keying
 * @date 2023-06-29 09:18:43
 */
public class Main230629 {

    public int computer(){
        int a = 1;
        int b = 2;
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        Main230629 main230629 = new Main230629();
        main230629.computer();
        main230629.sout();
    }

    private void sout(){
        System.out.println("通过自定义加载器，反射调用的方法");
    }
}