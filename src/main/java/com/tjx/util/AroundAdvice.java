package com.tjx.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕前>>>>>>>>>>>");
        Object result = methodInvocation.proceed();
        result = "我想喝牛奶";
        System.out.println(result);
        System.out.println("环绕后>>>>>>>>>>>");
        return result;
    }
}
