package com.qin.controller;

import com.qin.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController
{

    @GetMapping("/")
    public String index()
    {

//        System.out.println(id+nname);
        return "index";
    }

    @GetMapping("/blog")
    public String blog()
    {

//        System.out.println(id+nname);
        return "blog";
    }

    @GetMapping("/404")
    public String not()
    {

//        System.out.println(id+nname);
        return "error/404";
    }
}
