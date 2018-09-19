package com.tjx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void updateAccount(String name, double money) {
        String sql = "UPDATE account SET balance = balance - ? WHERE aname=?";
        this.getJdbcTemplate().update(sql,money,name);
    }
}
