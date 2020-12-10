package com.bjpowernode.factory;

import com.bjpowernode.service.USBSell;

public class USBFactory implements USBSell {
    @Override
    public float sell(int amount) {
        System.out.println("目标类中的方法调用,USBFactory中的sell");

        return 45.50f;
    }
}
