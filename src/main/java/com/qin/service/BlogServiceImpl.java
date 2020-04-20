package com.qin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qin.exception.NotFoundException;
import com.qin.mapper.BlogMapper;
import com.qin.mapper.BlogTagMapper;
import com.qin.pojo.*;
import com.qin.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private BlogTagMapper blogTagMapper;

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
        blogTagMapper.delBlogTagByBlogId(id);
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
        blog.tagsToTagIds();
        blog.setUpdateTime(new Date());
        blogTagMapper.delBlogTagByBlogId(blog.getId());
        for (Tag tag : blog.getTags()) {
            blogTagMapper.addBlogTag(blog.getId(),tag.getId());
        }
        return blogMapper.updateBlog(id,blog);
    }

    @Override
    @Transactional
    public int addBlog(Blog blog) {
        blog.setCreatTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blogMapper.addBlog(blog);
        for (Tag tag : blog.getTags()) {
            blogTagMapper.addBlogTag(blog.getId(),tag.getId());
        }
        return 1;
    }

    @Transactional
    @Override
    public PageResult getIndexBlog(PageRequest pageRequest) {

        return PageUtil.getPageResult(pageRequest,getIndexPageInfo(pageRequest));
    }

    @Override
    public List<Blog> getResentRecommendBlogs(Integer size) {
        return blogMapper.getResentRecommendBlogs(size);
    }
    private PageInfo<Blog> getIndexPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.getBlogs();
        return new PageInfo<Blog>(blogs);
    }


    @Override
    public PageResult getBlogBySearchTitleOrContent(PageRequest pageRequest,String p) {
        return PageUtil.getPageResult(pageRequest,getSearchResult(pageRequest,p));
    }
    private PageInfo<Blog> getSearchResult(PageRequest pageRequest,String p) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.getBlogBySearchTitleOrContent(p);
        return new PageInfo<Blog>(blogs);
    }




}
