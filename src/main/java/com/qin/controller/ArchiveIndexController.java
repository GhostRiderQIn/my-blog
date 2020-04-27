package com.qin.controller;

import com.qin.pojo.Blog;
import com.qin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: my-blog
 * @description: 归档
 * @author: qinda
 * @create: 2020-04-26 20:44
 **/
@Controller
public class ArchiveIndexController {

    @Autowired
    private BlogService blogService;
    @RequestMapping("/archives")
    public String archives(Model model)
    {
        Map<String,List<Blog>> map = new HashMap<>();
        List<String> archiveYear = blogService.getArchiveYear();
        int sum = 0;
        for (String s : archiveYear) {
            List<Blog> blogByYear = blogService.getBlogByYear(s);
            sum += blogByYear.size();
            map.put(s,blogByYear);
        }
        model.addAttribute("dates",archiveYear);
        model.addAttribute("blogs",map);
        model.addAttribute("sum",sum);
        return "archives";
    }
}
