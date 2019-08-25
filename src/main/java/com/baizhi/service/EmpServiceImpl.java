package com.baizhi.service;

import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDAO empDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> queryAll() {
        System.out.println("目标方法");
        return empDAO.selectAll();
    }

    @Override
    public void add(Emp emp) {
        empDAO.insert(emp);

    }

    @Override
    public void change(Emp emp) {
        empDAO.update(emp);

    }

    @Override
    public void remove(String id) {
        empDAO.delete(id);

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Emp queryById(String id) {
        return empDAO.selectOne(id);
    }
}
