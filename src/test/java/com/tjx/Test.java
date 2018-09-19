package com.tjx;

import com.tjx.bean.Student;
import com.tjx.dao.StudentDao;
import com.tjx.util.MyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    /**
     * Spring代理生成器
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aaa.xml");
        StudentDao factory = context.getBean("studentDao",StudentDao.class);
        //StudentDao factory1 = (StudentDao) context.getBean("studentDao1");
        factory.sleep();
        //factory1.sleep();
    }

    /**
     * 测试前置、后置、环绕增强
     */
    @org.junit.Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao proxy1 = (StudentDao) context.getBean("proxy1");
        proxy1.eat();
    }

    /**
     * 顾问
     */
    @org.junit.Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao proxy2 = (StudentDao) context.getBean("proxy2");
        proxy2.sleep();
    }

    /**
     * 正则
     */
    @org.junit.Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao proxy = (StudentDao) context.getBean("proxy");
        proxy.sleep();
        proxy.eat();
    }

    /**
     * 异常增强
     * 如果有前置增强和环绕增强，就会在异常增强运行前 先运行前置增强或环绕增强的环绕前的增强
     * 如果有后置增强 则不予理会
     */
    @org.junit.Test
    public  void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao proxy3 = (StudentDao) context.getBean("proxy3");
        try {
            proxy3.login("abc","534");
        }catch (MyException ex){
            ex.printStackTrace();
        }
    }

    @org.junit.Test
    public void test99(){
        String s1 = "Hello";
        System.out.println(s1+1+2);
        System.out.println(1+2+s1);

    }
}
