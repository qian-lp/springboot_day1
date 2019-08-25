package com.baizhi.dao;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpDAO {
    List<Emp> selectAll();

    void delete(String id);

    void insert(Emp emp);

    void update(Emp emp);

    Emp selectOne(String id);
}
