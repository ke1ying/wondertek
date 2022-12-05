package com.miu.web.huaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-17 11:30:45
 */
public class HwSF56 {


    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String duan = scanner.nextLine();
        String chang = scanner.nextLine();
        boolean f = true;
        for (int i = 0; i < duan.length(); i++) {
            if(!chang.contains(String.valueOf(duan.charAt(i)))){
                f = false;
                break;
            }
        }
        if(f){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }

}