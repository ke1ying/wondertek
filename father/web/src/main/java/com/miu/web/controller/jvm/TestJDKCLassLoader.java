package com.miu.web.controller.jvm;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;

/**
 * @author keying
 * @date 2023-06-29 14:52:26
 */
public class TestJDKCLassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        // 为什么第一个是null，因为引导类加载是c++的，不是java，所以看不到
        System.out.println(DESKeyFactory.class.getClassLoader());
        // 应用程序类扩展器
        System.out.println(TestJDKCLassLoader.class.getClassLoader());
        // 他们都是Launcher下的
        System.out.println("-----------------");
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("appClassLoader:" + appClassLoader);
        ClassLoader parentExt = appClassLoader.getParent();
        System.out.println("parentExt:" + parentExt);
        ClassLoader parentBootstrap = parentExt.getParent();
        System.out.println("parentBootstrap:" + parentBootstrap);
        System.out.println("-----------------");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }
        System.out.println("ext加载文件");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("appClassLoader加载以下文件");
        System.out.println(System.getProperty("java.class.path"));
    }
}