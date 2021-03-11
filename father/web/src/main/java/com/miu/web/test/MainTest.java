package com.miu.web.test;


public class MainTest {
    static class Value{
        public int i=15;
    }
    public static class Test{
        public static void main(String argv[]){
            System.out.println("test");
        }

        public void first( ){
            int i=5;
            Value v=new Value( );
            v.i=25;
            second(v,i);
            System.out.println(v.i);
        }

        public void second(Value j,int i){
            i = 0;
            j.i = 20;
            Value val = new Value( );
            j = val;
            System.out.println(j.i+" "+i);
        }
    }

    public static void main(String[] args) {

    }
}
