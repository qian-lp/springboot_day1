package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO {
    User select(String username);

    void insert(User user);
}
