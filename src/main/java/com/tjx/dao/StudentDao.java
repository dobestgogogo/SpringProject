package com.tjx.dao;

import com.tjx.bean.Student;
import com.tjx.util.MyException;

import java.io.Serializable;
import java.util.List;

public interface StudentDao {

    void sleep();
    String eat();
    boolean login(String userName,String pwd) throws MyException;
}
