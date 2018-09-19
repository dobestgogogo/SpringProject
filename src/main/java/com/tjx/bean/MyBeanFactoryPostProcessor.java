package com.tjx.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public MyBeanFactoryPostProcessor() {
        System.out.println("实例化MyBeanFactoryPostProcessor（无参构造）");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("执行MyBeanFactoryPostProcessor的postProcessBeanFactory（）");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("student");
        beanDefinition.getPropertyValues().addPropertyValue("name","二柱");
    }
}
