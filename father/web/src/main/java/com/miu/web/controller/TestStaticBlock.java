package com.miu.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
* 双亲委派test
* */

public class TestStaticBlock {
    static{
        System.out.println("static block init");
    }

    public void test(){
        //new TestStaticBlock();

        Class<?> class0 = TestStaticBlock.class;
        try {
            System.out.println(class0.getClassLoader() instanceof MyClassLoader);
            Class<?> class1 = class0.getClassLoader().loadClass("classloader.TestStaticBlock");
            ClassLoader classLoader = new MyClassLoader();
            Class<?> class2 = classLoader.loadClass("TestStaticBlock");

            System.out.println(class1.hashCode());
            System.out.println(class2.hashCode());
            System.out.println(class1.equals(class2));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //自定义一个类加载器从指定磁盘目录加载类
    public class MyClassLoader extends ClassLoader {
        //不破坏双亲委派模型
        @Override
        protected Class<?> findClass(String name) {
            String myPath = "D:/workspace/class/" + name.replace(".","/") + ".class";
            System.out.println(myPath);
            byte[] classBytes = null;
            FileInputStream in = null;

            try {
                File file = new File(myPath);
                in = new FileInputStream(file);
                classBytes = new byte[(int) file.length()];
                in.read(classBytes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Class<?> clazz = defineClass(name, classBytes, 0, classBytes.length);
            return clazz;
        }


    }

}
