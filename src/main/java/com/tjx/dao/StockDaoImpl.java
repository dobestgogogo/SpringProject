package com.tjx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockDaoImpl extends JdbcDaoSupport implements StockDao {
    @Override
    public void updateStock(String name, int amount) {
        String sql = "update stock set amount = amount + ? where sname= ?";
        this.getJdbcTemplate().update(sql,amount,name);
    }
}
