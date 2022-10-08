package com.example.springjunittest5.service.impl;

import com.example.springjunittest5.dao.IHelloDao;
import com.example.springjunittest5.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements IHelloService {
    @Autowired
    IHelloDao helloDao;
    @Override
    public String hello(String name) {
        helloDao.hello(name);
        return name;
    }
}
