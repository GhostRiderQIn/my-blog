package com.qin.service;

import com.qin.mapper.TypeMapper;
import com.qin.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @program: my-blog
 * @description: 分类操作
 * @author: qinda
 * @create: 2020-04-13 22:08
 **/
@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeMapper typeMapper;
    @Override
    public void addType(Type type) {
        typeMapper.addType(type);
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return null;
    }

    @Override
    public Type updateType(Long id, Type type) {
        typeMapper.updateType(id,type);
        return null;
    }

    @Override
    public void delType(Long id) {

    }
}
