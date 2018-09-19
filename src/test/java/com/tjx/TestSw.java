package com.tjx;

import com.tjx.dao.AccountDao;
import com.tjx.service.BuyStockService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSw {

    /**
     * 在没有加入事务：只减钱，不增股
     * 加入事务后：有异常，没有捕获，方法回滚
     *             没有异常，正常运行
     *  AspectJ 和 注解
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringSW.xml");
        BuyStockService buyStockService = (BuyStockService) context.getBean("buyStockService");
        //AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        buyStockService.buyStock("张三",500,100);

    }

    /**
     * 工厂
     */
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringSW.xml");
        BuyStockService proxyFactoryBean = (BuyStockService) context.getBean("proxyFactoryBean");
        proxyFactoryBean.buyStock("张三",500,200);
    }
}
