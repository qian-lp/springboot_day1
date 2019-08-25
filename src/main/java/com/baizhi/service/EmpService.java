package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> queryAll();

    void add(Emp emp);

    void change(Emp emp);

    void remove(String id);

    Emp queryById(String id);
}
