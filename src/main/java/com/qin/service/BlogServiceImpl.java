package com.qin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qin.exception.NotFoundException;
import com.qin.mapper.BlogMapper;
import com.qin.pojo.Blog;
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
 * @description:
 * @author: qinda
 * @create: 2020-04-16 16:59
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    @Transactional
    public Blog getBlogById(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    @Transactional
    public PageResult listBlog(PageRequest pageRequest, Blog blog) {
        return PageUtil.getPageResult(pageRequest,getPageInfo(pageRequest,blog));
    }
    private PageInfo<Blog> getPageInfo(PageRequest pageRequest,Blog blog) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.listBlog(blog);
        return new PageInfo<Blog>(blogs);
    }
    @Override
    @Transactional
    public int delBlog(Long id) {
        return blogMapper.delBlog(id);
    }

    @Override
    @Transactional
    public int updateBlog(Long id, Blog blog) {
        Blog b = blogMapper.getBlogById(id);
        if (b == null)
        {
            throw new NotFoundException("该博客不存在");
        }
        return blogMapper.updateBlog(id,blog);
    }

    @Override
    @Transactional
    public int addBlog(Blog blog) {
        return blogMapper.addBlog(blog);
    }
}
