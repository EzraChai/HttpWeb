package com.bjpowernode.seller;

import com.bjpowernode.factory.USBFactory;
import com.bjpowernode.service.USBSell;

public class WechatSeller implements USBSell {

    private USBFactory factory = new USBFactory();
    @Override
    public float sell(int amount) {

        float price = factory.sell(amount);
        price += 2;
        return price;
    }
}
