package com.miu.web.suanfa;

import com.miu.entity.User;

import javax.jws.soap.SOAPBinding;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TestSuanFa {
    int Sky = 10;
    int $Computer = 10;
    private int s = 1;
    static int i = 10;

    public static void main(String[] args)  {
        ArrayList list = new ArrayList();
        list.add("123");
        list.add("456");


        String [] arr =((Object)list).toString().split(",");

        System.out.println(arr);

    }

    void test(){
        System.out.println(Sky);
        System.out.println(s);
    }

}
