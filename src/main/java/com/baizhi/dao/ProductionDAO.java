package com.baizhi.dao;

import com.baizhi.entity.Production;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionDAO {
    List<Production> selectByPage(@Param("begin") Integer begin, @Param("rows") Integer rows);

    Production select(String id);

    Integer selectCount();
}
