package com.qin.service;

import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;
import com.qin.pojo.Type;
public interface TypeService {
    int addType(Type type);

    Type getType(Long id);

    PageResult listType(PageRequest pageRequest);

    int updateType(Long id, Type type);

    int delType(Long id);
}
