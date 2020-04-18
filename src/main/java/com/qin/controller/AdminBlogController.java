package com.qin.controller;

import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.service.BlogService;
import com.qin.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelExtensionsKt;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @Autowired
    private TypeService typeService;



    @RequestMapping("/blogs")
    public String blogs(PageRequest pageRequest, Blog blog, Model model)
    {
        System.out.println(blog);
        if (pageRequest.getPageSize() == 0 && pageRequest.getPageNum() == 0)
        {
            pageRequest.setPageSize(10);
            pageRequest.setPageNum(1);
        }
        model.addAttribute("types",typeService.getAllTypes());
        model.addAttribute("page",blogService.listBlog(pageRequest,blog));
        return "admin/blogs";
    }
    @RequestMapping("/blogs/search")
    public String search(PageRequest pageRequest, Blog blog, Model model)
    {
        System.out.println(blog);
        if (pageRequest.getPageSize() == 0 && pageRequest.getPageNum() == 0)
        {
            pageRequest.setPageSize(10);
            pageRequest.setPageNum(1);
        }
        model.addAttribute("page",blogService.listBlog(pageRequest,blog));
        return "admin/blogs :: blogList";
    }

    @RequestMapping("/blogs/{id}/input")
    public String update(@PathVariable Long id, Model model)
    {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog",blog);
        return "admin/blogs-input";
    }

    @RequestMapping("/blogs/{id}/delete")
    public String del(@PathVariable Long id, RedirectAttributes attributes)
    {
        int blog = blogService.delBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:admin/blogs-input";
    }

    @RequestMapping("/blogs/input")
    public String add(@Valid Blog blog, BindingResult result, RedirectAttributes attributes)
    {
        if(result.hasErrors())
        {
            return "/admin/types-input";
        }
        int i = blogService.addBlog(blog);
        if (i == 0)
            attributes.addFlashAttribute("message","添加成功");
        else
            attributes.addFlashAttribute("message","添加失败");
        return "redirect:admin/blogs-input";
    }
}
