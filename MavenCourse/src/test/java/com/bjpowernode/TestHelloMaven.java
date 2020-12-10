package com.bjpowernode;

import org.junit.Assert;
import org.junit.Test;
import com.bjpowernode.HelloMaven;

public class TestHelloMaven {
    @Test
    public void testAdd(){
        System.out.println("Test is running");
        HelloMaven helloMaven = new HelloMaven();
        int result = helloMaven.add(10,20);
        Assert.assertEquals(30,result);
    }
}
