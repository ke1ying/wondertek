package com.miu.web.suanfa;

public class test {

    public static void main(String[] args) {
        Integer arr[] = {2,5,6,33,1,10};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(arr.toString());
    }

}
