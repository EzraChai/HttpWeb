package com.bjpowernode;

import com.bjpowernode.impl.HelloServiceImpl;
import com.bjpowernode.impl.HelloServiceImpl2;
import com.bjpowernode.service.HelloService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloTest {
    public static void main(String[] args) {
//        HelloService helloService = new HelloServiceImpl();
//        helloService.sayHello("Chloe");

        //使用反射机制执行sayHello
        HelloService target = new HelloServiceImpl();
        HelloService target2 = new HelloServiceImpl2();
        try {
            Method method = HelloService.class.getMethod("sayHello", String.class);
            Object result = method.invoke(target2, "Chloe");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
