package com.bjpowernode.impl;

import com.bjpowernode.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }
}
