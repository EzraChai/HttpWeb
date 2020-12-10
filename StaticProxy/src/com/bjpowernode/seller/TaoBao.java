package com.bjpowernode.seller;

import com.bjpowernode.factory.USBFactory;
import com.bjpowernode.service.USBSell;

public class TaoBao implements USBSell {

    private USBFactory factory = new USBFactory();
    @Override
    public float sell(int amount) {
        float price = factory.sell(amount);
        price += 10;
        System.out.println("返回一个优惠卷");
        return price;
    }
}
