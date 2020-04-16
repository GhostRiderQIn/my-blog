package com.qin.service;

import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;

import javax.swing.*;

public interface BlogService {

    Blog getBlogById(Long id);

    PageResult listBlog(PageRequest pageRequest, Blog blog);

    int delBlog(Long id);

    int updateBlog(Long id, Blog blog);

    int addBlog(Blog blog);

}
