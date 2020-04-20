package com.qin.service;

import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;

import java.util.List;


public interface BlogService {

    Blog getBlogById(Long id);

    PageResult listBlog(PageRequest pageRequest, Blog blog);

    int delBlog(Long id);

    int updateBlog(Long id, Blog blog);

    int addBlog(Blog blog);

    PageResult getIndexBlog(PageRequest pageRequest);

    List<Blog> getResentRecommendBlogs(Integer size);

    PageResult getBlogBySearchTitleOrContent(PageRequest pageRequest,String p);
}
