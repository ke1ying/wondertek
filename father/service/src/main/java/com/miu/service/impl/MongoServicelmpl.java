package com.miu.service.impl;

import com.miu.entity.MongoBook;
import com.miu.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Service
public class MongoServicelmpl implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert() {
        MongoBook mongoBook = new MongoBook();
        mongoBook.setCreateTime(new Date());
        mongoBook.setUpdateTime(new Date());
        mongoTemplate.save(mongoBook);
    }

    @Override
    public void findAll() {
       List<MongoBook> list = mongoTemplate.findAll(MongoBook.class);
        list.forEach(e->{
            System.out.println(e);
        });
    }
}
