package com.qin.service;

import java.util.List;

import com.qin.mapper.TagMapper;
import com.qin.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qin.exception.NotFoundException;
import com.qin.mapper.TypeMapper;
import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;
import com.qin.pojo.Type;
import com.qin.util.PageUtil;

/**
 * @program: my-blog
 * @description: 分类操作
 * @author: qinda
 * @create: 2020-04-13 22:08
 **/
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagMapper tagMapper;

    @Transactional
    @Override
    public int addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagMapper.getTag(id);
    }

    @Transactional
    @Override
    public PageResult listTag(PageRequest pageRequest) {
        return PageUtil.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public List<Tag> getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    private PageInfo<Tag> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> tags = tagMapper.selectPage();
        return new PageInfo<Tag>(tags);
    }


    @Transactional
    @Override
    public int updateTag(Long id, Tag tag) {
        Tag t = tagMapper.getTag(id);
        if(t == null)
        {
            throw new NotFoundException("不存在改分类");
        }

        return tagMapper.updateTag(id,tag);
    }

    @Transactional
    @Override
    public int delTag(Long id) {
        return tagMapper.delTag(id);
    }
}
