//package ru.inordic.myProxy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.util.List;
//
//public class Test1 {
//
//    InvocationHandler ih = new InvocationHandler() {
//        @Override
//        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//            System.out.println("Call " + method.getName());
//            return "Fake";
//
//        }
//    };
//
//    List proxy =(List) java.lang.reflect.Proxy.newProxyInstance(
//            Thread.currentThread().getContextClassLoader(), new Class[]{List.class}, ih);
//
//    Object result = proxy.get(0);
//    int size = proxy.size();
//
//
//
//}
