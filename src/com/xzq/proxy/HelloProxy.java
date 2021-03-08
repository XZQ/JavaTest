package com.xzq.proxy;

public class HelloProxy implements HelloInterface {

    private HelloInterface helloInterface = new Hello();

    public HelloProxy(HelloInterface helloInterface) {
        this.helloInterface = helloInterface;
    }

    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello");
        helloInterface.sayHello();
        System.out.println("After invoke sayHello");
    }
}