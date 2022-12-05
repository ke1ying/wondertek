package com.miu.web.huaWei;

import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF24 {

    /**
     * 查找兄弟单词
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> stringList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringList.add(sb.toString());
                sb = new StringBuffer();
            } else {
                sb.append(str.charAt(i));
            }
        }

        stringList.add(sb.toString());


        String old = stringList.get(stringList.size() - 2);
        char [] sortOld = old.toCharArray();
       /* List<Character> characterListOld = new ArrayList<>();
        for (int i = 0; i < old.length(); i++) {
            characterListOld.add(old.charAt(i));
        }
        List<Character> sortOld =
                characterListOld.stream().sorted(Comparator.comparing(Character::charValue)).collect(Collectors.toList());
*/
        Arrays.sort(sortOld);

        List<String> brotherList = new ArrayList<>();
        for (int i = 1; i < stringList.size() - 2; i++) {
            // 相等不是兄弟
            if (stringList.get(i).equals(old)) {
                continue;
            }
            String newZ = stringList.get(i);
            // 长度不同也不是兄弟
            if (newZ.length() != old.length()) {
                continue;
            }
            // 值必须相同
  /*          List<Character> characterListNew = new ArrayList<>();
            for (int j = 0; j < newZ.length(); j++) {
                characterListNew.add(newZ.charAt(j));
            }
            List<Character> sortNew =
                    characterListNew.stream().sorted(Comparator.comparing(Character::charValue))
                            .collect(Collectors.toList());*/
            char[] sortNew = newZ.toCharArray();
            Arrays.sort(sortNew);

            if (new String(sortNew).equals(new String(sortOld))) {
                brotherList.add(newZ);
            }
        }

        brotherList = brotherList.stream().sorted
                (Comparator.comparing(String::valueOf)).collect(Collectors.toList());

        int index = Integer.valueOf(stringList.get(stringList.size() - 1));
        System.out.println(brotherList.size());
        if (!CollectionUtils.isEmpty(brotherList) && (index - 1 <= brotherList.size())) {
            System.out.println(brotherList.get(index - 1));
        }

    }

}