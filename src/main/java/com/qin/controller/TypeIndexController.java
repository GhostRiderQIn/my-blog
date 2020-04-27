package com.qin.controller;

import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.pojo.Type;
import com.qin.service.BlogService;
import com.qin.service.TypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: my-blog
 * @description:
 * @author: qinda
 * @create: 2020-04-26 11:55
 **/

@Controller
public class TypeIndexController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/types/{id}")
    public String toType(PageRequest pageRequest , @PathVariable Long id, Model model)
    {
        if (pageRequest.getPageNum()==0 && pageRequest.getPageSize() == 0)
        {
            pageRequest.setPageNum(1);
            pageRequest.setPageSize(5);
        }
        List<Type> allType = typeService.getTopType(-1);
        model.addAttribute("types",allType);
        Long tid = id;
        Blog blog = new Blog();
        if (id == -1)
            tid = allType.get(0).getId();
        blog.setTypeId(tid);
        model.addAttribute("page", blogService.listShowBlog(pageRequest, blog));
        model.addAttribute("active",tid);
        return "types";
    }


}












