package com.bjpowernode;

import com.bjpowernode.seller.TaoBao;
import com.bjpowernode.seller.WechatSeller;

public class ShopMain {
    public static void main(String[] args) {
        TaoBao taobao = new TaoBao();
        float price = taobao.sell(1);
        System.out.println("Price from TaoBao = "+price);

        System.out.println("--------------------");

        WechatSeller wechatSeller = new WechatSeller();
        float price2 = wechatSeller.sell(1);
        System.out.println("Price from Wechat Seller = " + price2);
    }
}
