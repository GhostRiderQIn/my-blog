package com.qin.service;

import com.qin.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByBlogId(Long id);

    int addComment(Comment comment);

    int delCommentByBlogId(Long id);

}
