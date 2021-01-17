package com.miu.web.controller;

public class MemoryMessage {
    public static void main(String[] args) {
        System.out.println("max memory（最大内存）:"+Runtime.getRuntime().maxMemory());
        System.out.println("free memory:"+Runtime.getRuntime().freeMemory());
        System.out.println("total memory(总共使用内存):"+Runtime.getRuntime().totalMemory());

        byte[] b1 = new byte[1*1024*1024];
        System.out.println("max memory" + Runtime.getRuntime().maxMemory());//最大内存
        System.out.println("free memory" + Runtime.getRuntime().freeMemory());//空闲内存
        System.out.println("total memory" + Runtime.getRuntime().totalMemory());//总共使用的内存

        System.out.println("==========================================================");

        byte[] b2 = new byte[4*1024*1024];
        System.out.println("max memory" + Runtime.getRuntime().maxMemory());//最大内存
        System.out.println("free memory" + Runtime.getRuntime().freeMemory());//空闲内存
        System.out.println("total memory" + Runtime.getRuntime().totalMemory());//总共使用的内存
    }
}
