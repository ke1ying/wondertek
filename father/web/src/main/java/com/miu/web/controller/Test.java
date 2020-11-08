package com.miu.web.controller;

import java.util.ArrayList;

public class Test{
    int i = 12;
    static int z = 13;

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.forEach(a->{
            System.out.println(a);
        });
    }



}
