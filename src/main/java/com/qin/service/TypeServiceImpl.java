package com.qin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qin.exception.NotFoundException;
import com.qin.mapper.TypeMapper;
import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;
import com.qin.pojo.Type;
import com.qin.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }

    @Transactional
    @Override
    public PageResult listType(PageRequest pageRequest) {
        return PageUtil.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<Type> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Type> types = typeMapper.selectPage();
        return new PageInfo<Type>(types);
    }


    @Transactional
    @Override
    public int updateType(Long id, Type type) {
        Type t = typeMapper.getType(id);
        if(t == null)
        {
            throw new NotFoundException("不存在改分类");
        }

        return typeMapper.updateType(id,type);
    }

    @Transactional
    @Override
    public int delType(Long id) {
        return typeMapper.delType(id);
    }
}
