package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keying
 * @date 2022-08-12 15:43:54
 */
public class HwSF13 {
    /**
     * I am a boy
     *
     * boy a am I
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer stringBuffer = new StringBuffer();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ' '){
                list.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            }else{
                stringBuffer.append(c);
            }
        }
        list.add(stringBuffer.toString());
        //  查询
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
        }
    }
}