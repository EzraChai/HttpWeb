package com.bjpowernode.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MySellHandler implements InvocationHandler {

    private Object target = null;

    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        Object oneAmount = null;
        Float totalAmount = 0.0f;

        //float price = factory.sell(amount);
        result = method.invoke(target, args); //执行目标方法
        oneAmount = method.invoke(target, 1);
        //price += 10;
//        if (result != null){
//            Float price = (Float)result;
//            price += 20;
//            result = price;
//        }
        Float price = (Float) result;
        while (price >= (Float) oneAmount) {
            totalAmount += (20 + (Float)oneAmount);
            price -= (Float) oneAmount;
        }

        System.out.println("返回一个优惠卷");

        return totalAmount;
    }
}
