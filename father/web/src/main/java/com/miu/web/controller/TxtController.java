package com.miu.web.controller;

import java.io.*;

public class TxtController {
    /**
     * 视频拷贝
     */
    public static void main(String[] args) throws IOException {
        //声明一个字节输入流
        FileInputStream fis = new FileInputStream("D://old//daiyang.mp4");
        //声明一个字节输出流
        FileOutputStream fos = new   FileOutputStream("D://ok//dai.mp4");
        //创建字节数组 读取数组写入数组
        byte[] b = new byte[1024];

        int len = 0 ;
        while( (len = fis.read(b)) !=-1){
            //System.out.print(new String(b,0,len));
            fos.write(b, 0, len);
        }
        //释放资源
        fis.close();
        fos.close();
    }
}
