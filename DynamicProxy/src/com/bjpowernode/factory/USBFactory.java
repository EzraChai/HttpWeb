package com.bjpowernode.factory;

import com.bjpowernode.service.USBSell;

public class USBFactory implements USBSell {
    @Override
    public float sell(int amount) {
        System.out.println("目标类中，执行sell目标方法");
        float price = amount * 45.50f;
        return price;
    }

    @Override
    public void print(String name) {
        System.out.println("HI " + name);
    }
}
