package com.tjx.util;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice {
    public void afterThrowing(MyException ex) {
        System.out.println("增强中的错误提示" + ex.getMessage());
    }
}
