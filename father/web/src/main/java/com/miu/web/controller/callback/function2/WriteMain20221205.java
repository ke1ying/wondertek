package com.miu.web.controller.callback.function2;

import java.io.FileWriter;

/**
 * @author keying
 * @date 2022-12-05 21:35:22
 */
public class WriteMain20221205 {
    public static void main(String[] args) {
        Write20221205 write20221205 = new Write20221205();
        write20221205.write("D:\\fw.txt", fileWriter -> {
            try{
                fileWriter.write("write 20221205");
            }catch (Exception e){

            }
        });
     /*   Write20221205 write20221205 = new Write20221205();
        write20221205.write("D:\\fw.txt", new Callback1205() {
            @Override
            public void append(FileWriter fileWriter) {
                try{
                    fileWriter.write("回调");
                }catch (Exception e){

                }

            }
        });*/
    }
}