package com.qin.controller;

import com.qin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端博客展示
 * @program: my-blog
 * @description:
 * @author: qinda
 * @create: 2020-04-18 21:09
 **/
@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogs")
    public String listBlog()
    {
        return "admin/blogs";
    }
}
