package com.qin.service;

import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;
import com.qin.pojo.Type;

import java.util.List;

public interface TypeService {
    int addType(Type type);

    Type getType(Long id);

    PageResult listType(PageRequest pageRequest);

    List<Type> getAllTypes();

    List<Type> getTypeByName(String name);

    int updateType(Long id, Type type);

    int delType(Long id);

    List<Type> getTopType(Integer size);
}
