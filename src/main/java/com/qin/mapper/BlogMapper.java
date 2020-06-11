package com.qin.mapper;

import com.qin.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface BlogMapper {
    Blog getBlogById(@Param("id") Long id);
    List<Blog> getBlogs();


    List<Blog> listBlog(Blog blog);

    List<Blog> listShowBlog(Blog blog);

    List<Blog> getBlogByTag(Long id);

    int delBlog(@Param("id") Long id);

    int updateBlog(@Param("id") Long id,@Param("blog") Blog blog);

    int addBlog(Blog blog);

    List<Blog> getResentRecommendBlogs(Integer size);

    List<Blog> getBlogBySearchTitleOrContent(@Param("p") String p);

    List<String> getArchiveYear();

    List<Blog> getBlogByYear(String year);

}
