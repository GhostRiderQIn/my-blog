package com.qin.controller;

import com.qin.exception.NotFoundException;
import com.qin.pojo.PageRequest;
import com.qin.pojo.Tag;
import com.qin.pojo.Type;
import com.qin.service.BlogService;
import com.qin.service.TagService;
import com.qin.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController
{

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(PageRequest pageRequest, Model model)
    {
        if (pageRequest.getPageNum() == 0 && pageRequest.getPageSize() == 0)
        {
            pageRequest.setPageNum(1);
            pageRequest.setPageSize(5);
        }
        model.addAttribute("page",blogService.getIndexBlog(pageRequest));
        model.addAttribute("types",typeService.getTopType(6));
        model.addAttribute("tags",tagService.getTagTopList(8));
        model.addAttribute("ResentRecommend",blogService.getResentRecommendBlogs(5));
        return "index";
    }

    @PostMapping("/search")
    public String search(PageRequest pageRequest,@RequestParam String query,Model model)
    {
        if (pageRequest.getPageSize() == 0&&pageRequest.getPageNum() == 0)
        {
            pageRequest.setPageSize(5);
            pageRequest.setPageNum(1);
        }
        System.out.println(blogService.getBlogBySearchTitleOrContent(pageRequest,query).getTotalSize());
        model.addAttribute("result",blogService.getBlogBySearchTitleOrContent(pageRequest,query));
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model)
    {
        model.addAttribute("blog",blogService.getBlogByIdAndConvert(id));
        return "blog";
    }


}
