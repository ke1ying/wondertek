package com.miu.web.controller.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keying
 * @date 2023-07-03 08:49:27
 */
public class HeapTest {
    // 100kb
    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws Exception {
        List<HeapTest> heapTestList = new ArrayList<>();
        while (true){
            heapTestList.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}