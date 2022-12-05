package com.miu.web.huaWei;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author keying
 * @date 2022-08-08 14:29:40
 */
public class HwSF3 {

    public static void main(String[] args) throws IOException {
     /*   Scanner in = new Scanner(System.in);
        TreeSet treeSet = new TreeSet();
        while(in.hasNext()){
            int count = in.nextInt();
            
            for (int i = 0; i < count; i++) {
                treeSet.add(in.nextInt());
            }
            Object[] a = treeSet.toArray();
            Arrays.sort(a);

            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
            treeSet.clear();
        }*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i = Integer.valueOf(s);
        TreeSet set = new TreeSet();
        // 获取每行数据
        for (int j = 0; j < i; j++) {
            String z = br.readLine();
            set.add(Integer.valueOf(z));
        }

        Object [] o = set.toArray();
        Arrays.sort(o);

        for (int j = 0; j < o.length; j++) {
            System.out.println(o[j]);
        }
    }

}