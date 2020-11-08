package com.miu.web.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuaWeiSuanFa3 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bf.readLine())!=null)
        {

            boolean[] stu=new boolean[1001];
            StringBuilder sb=new StringBuilder();
            int n=Integer.parseInt(str);
            for(int i=0;i<n;i++)
                stu[Integer.parseInt(bf.readLine())]=true;
            for(int i=0;i<1001;i++)
                if(stu[i])
                    sb.append(i).append("\n");
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }

}
