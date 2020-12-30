package ru.inordic.myProxy;

import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {


    static <T> T createProxy(Class<T> extractorInterface) {
        //TODO здесь должна быть реализация

        Class[] classes = new Class[]{extractorInterface};
        InvocationHandler handler = new MyHandler();
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), classes, handler);

        return (T) proxy;
    }

}
