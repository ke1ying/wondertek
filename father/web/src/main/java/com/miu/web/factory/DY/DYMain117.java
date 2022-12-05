package com.miu.web.factory.DY;

/**
 * @author keying
 * @date 2022-11-07 22:06:28
 */
public class DYMain117 {

    public static void main(String[] args) {
        DYOrderFactory dyOrderFactory = new DYOrderFactory("DY");
        System.out.println(dyOrderFactory.getChannel());
        dyOrderFactory.order();
    }

}