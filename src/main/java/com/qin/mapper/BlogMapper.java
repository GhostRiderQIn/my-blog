package com.qin.mapper;

import com.qin.pojo.Blog;
import com.qin.pojo.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
@Mapper
@Repository
public interface BlogMapper {
    Blog getBlogById(@Param("id") Long id);

    List<Blog> listBlog(Blog blog);

    int delBlog(@Param("id") Long id);

    int updateBlog(@Param("id") Long id,@Param("blog") Blog blog);

    int addBlog(Blog blog);
}
