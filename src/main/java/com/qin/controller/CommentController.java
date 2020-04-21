package com.qin.controller;

import com.qin.pojo.Comment;
import com.qin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @program: my-blog
 * @description:
 * @author: qinda
 * @create: 2020-04-21 15:25
 **/
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${comment.avatar}")
    private String avatar;
    @GetMapping("/comment/{blogId}")
    public String comments(@PathVariable Long blogId, Model model)
    {
        model.addAttribute("comments",commentService.getCommentsByBlogId(blogId));
        return "blog :: commentList";
    }


    @PostMapping("/comments")
    public String post(Comment comment)
    {
        System.out.println(avatar);
        comment.setAvatar(avatar);
        commentService.addComment(comment);
        String a = "redirect:/comment/" + comment.getBlogId();
        return a;
    }

}
