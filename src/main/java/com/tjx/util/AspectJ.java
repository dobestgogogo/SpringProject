package com.tjx.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJ {

    @Before("execution(* *..StudentDao.*(..))")
    public void before(){
        System.out.println("前置增强***********");
    }

    @AfterReturning("execution(* *..StudentDao.eat(..))")
    public void after(){
        System.out.println("后置增强***********");
    }

    @AfterReturning(value = "execution(* *..StudentDao.sleep(..))",returning = "result")
    public void after(String result){
        System.out.println("后置增强*******"+result);
    }

    @Around("execution(* *..StudentDao.sleep(..))")
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
