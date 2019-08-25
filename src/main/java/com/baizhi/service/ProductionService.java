package com.baizhi.service;

import com.baizhi.entity.Production;

import java.util.List;

public interface ProductionService {
    List<Production> queryAll(Integer page, Integer rows);

    Integer count();

    Production queryOne(String id);
}
