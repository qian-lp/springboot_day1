package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    User selectByName(String username);

    void add(User user);

}
