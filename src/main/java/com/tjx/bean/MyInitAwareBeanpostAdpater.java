package com.tjx.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import java.beans.PropertyDescriptor;
public class MyInitAwareBeanpostAdpater extends InstantiationAwareBeanPostProcessorAdapter {

    public  MyInitAwareBeanpostAdpater(){
        System.out.println("实例化MyInitAwareBeanpostAdpater（无参构造）");
    }
    //在实例化bean之前调用
    public Object postProcessBeforeInstantiation(Class<?> beanClass,String beanName) throws BeansException{
        System.out.println("执行了MyInitAwareBeanpostAdpater的 postProcessBeforeInstantiation（）");
        return null; //底层返回的就是null
    }

    //在实例化bean之后调用
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行了MyInitAwareBeanpostAdpater的 postProcessAfterInitialization（）");
        return bean;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("执行了MyInitAwareBeanpostAdpater的 postProcessPropertyValues（）");
        return pvs;
    }
}
