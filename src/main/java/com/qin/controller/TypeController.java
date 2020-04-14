package com.qin.controller;

import com.qin.pojo.PageRequest;
import com.qin.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: my-blog
 * @description: Type
 * @author: qinda
 * @create: 2020-04-14 22:37
 **/
@Controller
@RequestMapping("/admin")
public class TypeController
{
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String list(PageRequest pageRequest, Model model)
    {
        model.addAttribute("page",typeService.listType(pageRequest));
        return "admin/types";
    }

}
