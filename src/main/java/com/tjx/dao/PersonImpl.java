package com.tjx.dao;

public class PersonImpl extends Person {
    @Override
    public void eat() {
        System.out.println("该吃吃");
    }

    @Override
    public void sleep() {
        System.out.println("该喝喝");
    }
}
