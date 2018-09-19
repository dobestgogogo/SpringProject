package com.tjx.util;

import com.tjx.dao.Person;
import com.tjx.dao.PersonImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object createProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("之前>>>>>>>>");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("之后>>>>>>>>");
        return o1;
    }

    public static void main(String[] args) {
        CglibProxy clp = new CglibProxy();
        Person proxy = (Person) clp.createProxy(new PersonImpl().getClass());
        proxy.eat();
        proxy.sleep();
    }
}
