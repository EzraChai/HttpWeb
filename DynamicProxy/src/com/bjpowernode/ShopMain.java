package com.bjpowernode;


import com.bjpowernode.factory.USBFactory;
import com.bjpowernode.handler.MySellHandler;
import com.bjpowernode.service.USBSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ShopMain {
    public static void main(String[] args) {
        //创建目标对象
        USBSell factory = new USBFactory();
        //创建InvocationHandler对象
        InvocationHandler handler = new MySellHandler(factory);
        //创建代理对象
        USBSell proxy = (USBSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), handler);
        //通过代理执方法
        float price = proxy.sell(2);
        System.out.println("通过动态代理对象调用方法");
        System.out.println(price);

    }
}
