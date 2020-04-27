package com.qin.service;

import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;

import java.util.List;


public interface BlogService {

    Blog getBlogById(Long id);

    Blog getBlogByIdAndConvert(Long id);

    PageResult listBlog(PageRequest pageRequest, Blog blog);
    PageResult listShowBlog(PageRequest pageRequest, Blog blog);
    PageResult getBlogByTag(PageRequest pageRequest, Long id);

    int delBlog(Long id);

    int updateBlog(Long id, Blog blog);

    int addBlog(Blog blog);

    PageResult getIndexBlog(PageRequest pageRequest);

    List<Blog> getResentRecommendBlogs(Integer size);

    List<String> getArchiveYear();

    List<Blog> getBlogByYear(String year);

    PageResult getBlogBySearchTitleOrContent(PageRequest pageRequest,String p);
}
