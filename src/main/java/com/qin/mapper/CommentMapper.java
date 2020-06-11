package com.qin.mapper;

import com.qin.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    List<Comment> getRootCommentsByBlogId(@Param("id") Long id);

    List<Comment> getCommentsByParentId(@Param("blogId") Long blogId,@Param("parId") Long parId);

    int addComment(Comment comment);

    int delCommentByBlogId(@Param("id") Long id);
}
