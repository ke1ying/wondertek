package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keying
 * @date 2022-08-23 19:22:10
 */
public class HwSF26 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> characterList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                if(!stringBuffer.toString().equals("")){
                    characterList.add(stringBuffer.toString());
                }
                stringBuffer = new StringBuffer();
            }else if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') ||
                    (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')){
                stringBuffer.append(str.charAt(i));
            }else{
                if(!stringBuffer.toString().equals("")){
                    characterList.add(stringBuffer.toString());
                }

                stringBuffer = new StringBuffer();
            }
        }
        characterList.add(stringBuffer.toString());
        for (int i = characterList.size()-1; i >= 0; i--) {
            System.out.print(characterList.get(i)+" ");
        }
    }

}