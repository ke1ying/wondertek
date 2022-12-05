package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-11-17 11:30:45
 */
public class HwSF55 {

    /**
     * 4
     * A B C D
     * 8
     * A D E CF A GG A B
     * 复制
     * 输出：
     * A : 3
     * B : 1
     * C : 0
     * D : 1
     * Invalid : 3
     * 复制
     * 说明：
     * E CF GG三张票是无效的，所以Invalid的数量是3.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer hx = Integer.valueOf(bufferedReader.readLine());
        String hxName = bufferedReader.readLine();
        Integer tp = Integer.valueOf(bufferedReader.readLine());
        String tpName = bufferedReader.readLine();

        // 候选name
        List<String> hxList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < hxName.length(); i++) {
            if (hxName.charAt(i) != ' ') {
                stringBuffer.append(hxName.charAt(i));
            } else {
                hxList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            }
        }
        hxList.add(stringBuffer.toString());

        // 投票name
        StringBuffer stringBufferTp = new StringBuffer();
        List<String> tpList = new ArrayList<>();
        for (int i = 0; i < tpName.length(); i++) {
            if (tpName.charAt(i) != ' ') {
                stringBufferTp.append(tpName.charAt(i));
            } else {
                tpList.add(stringBufferTp.toString());
                stringBufferTp = new StringBuffer();
            }
        }
        tpList.add(stringBufferTp.toString());

        // Invalid
        List<String> invalidList = new ArrayList<>();
        for (int tpI = 0; tpI < tpList.size(); tpI++) {
            int n = 0;
            for (int i = 0; i < hxList.size(); i++) {
                // 一个投票 跟 所有 候选人比较，只要有一个 满足，则不 失效
                if (!tpList.get(tpI).equals(hxList.get(i))) {
                    n++;
                }
                if(n == hxList.size()){
                    invalidList.add(tpList.get(tpI));
                }
            }

        }

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < hxList.size(); i++) {
            for (int i1 = 0; i1 < tpList.size(); i1++) {
                // 候选人 里面有几个 张票
                if (hxList.get(i).equals(tpList.get(i1))) {
                    map.put(hxList.get(i), map.getOrDefault(hxList.get(i), 0) + 1);
                }
            }
        }

        for (int i = 0; i < hxList.size(); i++) {
            System.out.println(hxList.get(i) + " : " + (map.get(hxList.get(i)) == null ? 0 : map.get(hxList.get(i))));
        }
        System.out.println("Invalid : " + invalidList.size());

    }

}