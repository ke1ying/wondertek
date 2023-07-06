package com.miu.web.controller.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author keying
 */
public class JOLSample {
    /**
     *
     *         <dependency>
     *             <groupId>org.openjdk.jol</groupId>
     *             <artifactId>jol-core</artifactId>
     *             <version>0.9</version>
     *         </dependency>
     */
    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());

        System.out.println();
        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout1.toPrintable());

        System.out.println();
        ClassLayout layout2 = ClassLayout.parseInstance(new A());
        System.out.println(layout2.toPrintable());
    }
    static class A{
        int id;
        String name;
        byte b;
        Object o;
    }
}