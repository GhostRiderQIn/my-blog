package com.qin.service;

import com.qin.mapper.CommentMapper;
import com.qin.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: my-blog
 * @description:
 * @author: qinda
 * @create: 2020-04-21 15:36
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    @Transactional
    public List<Comment> getCommentsByBlogId(Long id) {

        List<Comment> list = commentMapper.getRootCommentsByBlogId(id);

        for (Comment comment : list) {
            comment.setReplyComments(commentMapper.getCommentsByParentId(id,comment.getId()));
//            System.out.println(commentMapper.getCommentsByParentId(id,comment.getId()));
        }
        
        return list;
    }

    @Override
    @Transactional
    public int addComment(Comment comment) {
        comment.setCreatTime(new Date());
        return commentMapper.addComment(comment);
    }

    @Override
    public int delCommentByBlogId(Long id) {
        commentMapper.delCommentByBlogId(id);
        return 0;
    }
}
