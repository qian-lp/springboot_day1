package com.baizhi.service;

import com.baizhi.dao.ProductionDAO;
import com.baizhi.entity.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    private ProductionDAO productionDAO;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Production> queryAll(Integer page, Integer rows) {
        Integer begin = (page - 1) * rows;
        return productionDAO.selectByPage(begin, rows);
    }


    @Override
    public Integer count() {
        return productionDAO.selectCount();
    }

    @Override
    public Production queryOne(String id) {
        return productionDAO.select(id);
    }


}
