package com.qin.service;

import com.qin.pojo.User;

public interface UserService {
    User checkUser(String username, String password);
}
