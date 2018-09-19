package com.tjx.bean;

import com.tjx.dao.Person;
import com.tjx.dao.PersonImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StudentProxy implements InvocationHandler {
    /**
     * 类型不能用具体的类型，因为跟不知道谁是委托类
     */
    private Object object;

    public Object createProxy(Object target){
        this.object = target;//知道委托类是谁         类的加载器                      实现类的接口      invocationHandler
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    /**
     * @param proxy 代理类对象
     * @param method 增强方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("之前>>>>>>>");
        Object invoke = method.invoke(object, args);
        System.out.println("之后>>>>>>>");
        return invoke;
    }
    public static void main(String[] args) {
        StudentProxy sp = new StudentProxy();
        Person person = (Person) sp.createProxy(new PersonImpl());
        person.eat();
        person.sleep();
    }
}
