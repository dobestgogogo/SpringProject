package com.tjx.service;

import com.tjx.dao.AccountDao;
import com.tjx.dao.StockDao;
import com.tjx.util.BuyStockException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyStockServiceImpl implements BuyStockService {
    private AccountDao accountDao;
    private StockDao stockDao;

    public BuyStockServiceImpl() {
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        System.out.println("进入setAccountDao");
        this.accountDao = accountDao;
    }

    public StockDao getStockDao() {
        return stockDao;
    }

    public void setStockDao(StockDao stockDao) {
        System.out.println("进入setStockDao");
        this.stockDao = stockDao;
    }

   /* @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = BuyStockException.class)*/
    public void buyStock(String name, double money, int acoount) {
        accountDao.updateAccount(name,money);
        if (1==1){
            throw new BuyStockException("购买股票失败");
        }
        stockDao.updateStock(name,acoount);
    }
}
