package com.miu.web.comment;

public class MyHashMapTest {
    public static void main(String[] args) throws Exception {
        MyHashMap<String,Object> myHashMap = new MyHashMap<String,Object>();
        myHashMap.put("123","234");
        myHashMap.put("a","vvv");
        System.out.println( myHashMap.get("123"));
        System.out.println( myHashMap.get("a"));
    }
}
