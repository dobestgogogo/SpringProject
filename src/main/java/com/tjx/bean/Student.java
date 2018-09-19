package com.tjx.bean;

import com.tjx.dao.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Student{
    //implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean
    private int sId;
    private String sName;
    private int age;

    /*private String beanName; //bean在容器中id或name
    private BeanFactory beanFactory;//bean所在的工厂*/

    /*@Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware中的setBeanFactory（）");
        this.beanFactory=beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("BeanNameAware接口中的setBeanName（）");
        this.beanName=beanName;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean中的destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean中的afterPropertiesSet()");
    }*/

    /*public void initMethod(){
        System.out.println("Student类中的initMethod（）");
    }

    public  void myDestroy() {
        System.out.println("Student类中的myDestroy（）");
    }*/

    public Student() {
        System.out.println("student无参构造");
    }

    public Student(int sId, String sName, int age) {
        System.out.println("student有参构造");
        this.sId = sId;
        this.sName = sName;
        this.age = age;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                '}';
    }
}
