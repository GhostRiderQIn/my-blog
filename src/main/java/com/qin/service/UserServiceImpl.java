package com.qin.service;

import com.qin.mapper.UserMapper;
import com.qin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: my-blog
 * @description: 用户业务
 * @author: qinda
 * @create: 2020-04-12 23:23
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        return userMapper.checkUser(username, password);
    }
}
