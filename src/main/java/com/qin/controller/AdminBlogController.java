package com.qin.controller;

import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogs")
    public String blogs(PageRequest pageRequest, Blog blog, Model model)
    {
        System.out.println(blog);
        if (pageRequest.getPageSize() == 0 && pageRequest.getPageNum() == 0)
        {
            pageRequest.setPageSize(10);
            pageRequest.setPageNum(1);
        }
        model.addAttribute("page",blogService.listBlog(pageRequest,blog));
        return "admin/blogs";
    }
}
