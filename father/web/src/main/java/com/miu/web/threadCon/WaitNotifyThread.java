package com.miu.web.threadCon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyThread {

    /*
    * 唤醒等待代码
    *
    * */
    public static void main(String[] args) {
        UserClass userClass = new UserClass();
        InputClass inputClass = new InputClass(userClass);
        OutputClass outputClass = new OutputClass(userClass);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(inputClass);
        executorService.execute(outputClass);

        executorService.shutdown();
    }

    static class InputClass implements Runnable{

        private UserClass userClass;

        public  InputClass(UserClass userClass){
            this.userClass=userClass;
        }

        @Override
        public void run() {
            while(true){
                synchronized (userClass){
                    if(userClass.flag){
                        System.out.println("Input等待进入");
                        try{
                            userClass.wait();
                        }catch (Exception e){

                        }
                    }
                    System.out.println("写数据");
                    userClass.setName("张三");
                    userClass.setAge("18");
                    UserClass.flag = true;
                    userClass.notify();
                    System.out.println("唤醒OutPut线程");
                }
            }
        }
    }

    static class OutputClass implements Runnable{

        private UserClass userClass;

        public  OutputClass(UserClass userClass){
            this.userClass=userClass;
        }

        @Override
        public void run() {
            while(true){
                synchronized (userClass){
                    if(!userClass.flag){
                        System.out.println("OutPut等待进入");
                        try{
                            userClass.wait();
                        }catch (Exception e){

                        }
                    }

                    System.out.println("输出:"+userClass.getName()+",age:"+ userClass.getAge());
                    UserClass.flag = false;
                    userClass.notify();
                    System.out.println("唤醒写线程");
                }
            }
        }
    }

     static class UserClass {
        private String name;

        private String age;

        private static boolean flag = false;

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String getAge() {
             return age;
         }

         public void setAge(String age) {
             this.age = age;
         }
     }
}
