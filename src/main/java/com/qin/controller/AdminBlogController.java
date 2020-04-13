package com.qin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: my-blog
 * @description: 博客管理
 * @author: qinda
 * @create: 2020-04-13 21:21
 **/
@Controller
@RequestMapping("/admin")
public class AdminBlogController {

    @RequestMapping("/blogs")
    public String blogs()
    {
        return "admin/blogs";
    }

}
