package com.qin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BlogTagMapper {
    int addBlogTag(@Param("blogId") Long blogId,@Param("tagId") Long tagId);

    int delBlogTagByBlogId(@Param("id") Long id);
}
