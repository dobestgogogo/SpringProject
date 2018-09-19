package com.tjx.dao;

import com.tjx.bean.Student;
import com.tjx.util.MyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void sleep() {
        System.out.println("睡觉>>>>>>>>>");
    }

    @Override
    public String eat() {
        System.out.println("吃饭>>>>>>>>>");
        return "我想吃饺子";
    }

    @Override
    public boolean login(String userName, String pwd) throws MyException {
        if(!"tjx".equals(userName)){
            throw new MyException("用户名错误！");
        }
        if (!"534".equals(pwd)){
            throw new MyException("密码错误！");
        }
        return true;
    }
}
