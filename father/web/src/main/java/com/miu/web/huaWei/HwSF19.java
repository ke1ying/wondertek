package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF19 {

    private static Map<String,String> map = new HashMap<>();
    static{
        map.put("abc","2");
        map.put("def","3");
        map.put("ghi","4");
        map.put("jkl","5");
        map.put("mno","6");
        map.put("pqrs","7");
        map.put("tuv","8");
        map.put("wxyz","9");
    }

    /**
     * abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Y') {
                char c1 = (char)(c+32+1);
                sb.append(c1);
                continue;
            }else if(c == 'Z'){
                sb.append("a");
                continue;
            }

            if (c >= 'a' && c <= 'z') {
                for (String key: map.keySet()) {
                    if(key.contains(String.valueOf(c))){
                        sb.append(map.get(key));
                    }
                }

                continue;
            }

            sb.append(c);
        }
        System.out.println(sb.toString());
    }


}