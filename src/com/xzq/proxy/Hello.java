package com.xzq.proxy;

public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello zhanghao!");
    }
}