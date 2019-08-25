package com.baizhi.service;

import com.baizhi.entity.Production;

import javax.servlet.http.HttpServletRequest;

public interface ShoppingService {
    //购物项
    Production queryById(String id, HttpServletRequest request);

    void modify(String id, Integer count, HttpServletRequest request);

    Production removeById(String id, HttpServletRequest request);
}
