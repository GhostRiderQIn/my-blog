package com.qin.controller;

import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.pojo.Tag;
import com.qin.pojo.Type;
import com.qin.service.BlogService;
import com.qin.service.TagService;
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
 * @create: 2020-04-26 16:26
 **/
@Controller
public class TagIndexController {
    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;
    @RequestMapping("/tags/{id}")
    public String toTags(PageRequest pageRequest, @PathVariable Long id, Model model)
    {
        if (pageRequest.getPageNum()==0 && pageRequest.getPageSize() == 0)
        {
            pageRequest.setPageNum(1);
            pageRequest.setPageSize(5);
        }
        List<Tag> allTag = tagService.getTagTopList(-1);

        model.addAttribute("tags",allTag);
        Long tid = id;
        if (id == -1)
            tid = allTag.get(0).getId();
        Tag tag1 = null;
        for (Tag tag : allTag) {
            if (tag.getId() == tid)
                tag1 = tag;
        }
        model.addAttribute("page", blogService.getBlogByTag(pageRequest, tid));
        model.addAttribute("active",tid);
        model.addAttribute("tag",tag1);
        return "tags";


    }
}
