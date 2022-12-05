package com.miu.web.controller.callback.function2;

import java.io.FileWriter;

/**
 * @author keying
 * @date 2022-12-05 21:33:10
 */
public class Write20221205 {

    public void write(String filename, Callback1205 callback1205) {
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter(filename,true);
            callback1205.append(fileWriter);
            fileWriter.flush();
            fileWriter.close();
        }catch (Exception e){

        }
    }
}