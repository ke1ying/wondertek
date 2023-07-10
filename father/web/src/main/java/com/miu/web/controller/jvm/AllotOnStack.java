package com.miu.web.controller.jvm;

import com.miu.web.test.day1012.guan.User;

/**
 * @author keying
 */
public class AllotOnStack {
    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            thread();
        }
    }

    private static void thread() {
        GcUser gcUser = new GcUser();
        gcUser.setName("name");
    }
}