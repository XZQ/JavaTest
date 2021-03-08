package com.xzq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyHanderTest {

    public static void main(String[] args) {


        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        HelloInterface hello = new Hello();
        ByeInterface bye = new Bye();


        InvocationHandler handler = new ProxyHandler(hello);
        InvocationHandler handler1 = new ProxyHandler(bye);


        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        ByeInterface proxyBye = (ByeInterface) Proxy.newProxyInstance(bye.getClass().getClassLoader(), bye.getClass().getInterfaces(), handler1);

        proxyHello.sayHello();
        System.out.println();
        proxyBye.sayBye();


    }
}
