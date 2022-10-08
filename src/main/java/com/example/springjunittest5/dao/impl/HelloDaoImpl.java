package com.example.springjunittest5.dao.impl;

import com.example.springjunittest5.dao.IHelloDao;
import org.springframework.stereotype.Component;

@Component
public class HelloDaoImpl implements IHelloDao {
    @Override
    public String hello(String name) {
        return name;
    }
}
