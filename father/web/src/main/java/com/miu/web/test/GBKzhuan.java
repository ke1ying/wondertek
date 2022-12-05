package com.miu.web.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;

import java.io.UnsupportedEncodingException;

public class GBKzhuan {

    public static void main(String[] args) throws Exception {
        byte s = 12;
//        new String(s,"GBK").getBytes("UTF-8");
        String string="中国人";
        System.out.println(string);
        String ceshi = new String(string.getBytes("UTF-8"),"GBK");
        String gbk = new String(string.getBytes("UTF-8"),"GBK");
        System.out.println(gbk);
        String st = new String(gbk.getBytes("GBK"),"UTF-8");
        System.out.println(st);
    }
}
