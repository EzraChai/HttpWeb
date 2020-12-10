package com.bjpowernode;

public class HelloMaven {
    public int add(int n1 , int n2){
        return n1 + n2;
    }

    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        int result = helloMaven.add(10,20);
        System.out.println("10 + 20 = " + result);
    }
}
