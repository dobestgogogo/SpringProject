package com.tjx.util;

import org.aspectj.lang.ProceedingJoinPoint;
public class AspectJ2 {

    public void before(){
        System.out.println("前置增强***********");
    }

    public void after(){
        System.out.println("后置增强***********");
    }

    public void after(String result){
        System.out.println("后置增强*******"+result);
    }

    public void around(ProceedingJoinPoint point){
        System.out.println("环绕前");
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后");
    }
}
