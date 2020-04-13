package com.qin.mapper;

import com.qin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
    User checkUser(String username, String password);
}
