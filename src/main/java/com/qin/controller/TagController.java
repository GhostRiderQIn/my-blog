package com.qin.controller;

import javax.validation.Valid;

import com.qin.pojo.Tag;
import com.qin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qin.pojo.PageRequest;
import com.qin.pojo.Type;
import com.qin.service.TypeService;

/**
 * @program: my-blog
 * @description: Type
 * @author: qinda
 * @create: 2020-04-14 22:37
 **/
@Controller
@RequestMapping("/admin")
public class TagController
{
    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String list(PageRequest pageRequest, Model model)
    {
        if(pageRequest.getPageNum() == 0 && pageRequest.getPageSize() == 0)
        {
            pageRequest = new PageRequest();
            pageRequest.setPageNum(1);
            pageRequest.setPageSize(10);
        }
        model.addAttribute("page",tagService.listTag(pageRequest));
        return "admin/tags";
    }

    @RequestMapping("/tags/input")
    public String toAddTag(Model model)
    {
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    @RequestMapping("/tags/{id}/input")
    public String toUpdateTag(@PathVariable Long id, Model model)
    {
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag",tag);
        return "admin/tags-input";
    }

    @RequestMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id,RedirectAttributes attributes)
    {
        int tag = tagService.delTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags")
    public String addTag(@Valid Tag tag, BindingResult result, RedirectAttributes attributes)
    {
        if(tagService.getTagByName(tag.getName()).size() != 0)
        {
            result.rejectValue("name","nameError","不能重复添加");
        }
        if(result.hasErrors())
        {
            return "/admin/tags-input";
        }
        int i = tagService.addTag(tag);
        if (i == 0)
        {
            attributes.addFlashAttribute("message","操作失败!");
        }
        else
        {
            attributes.addFlashAttribute("message","操作成功!");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String updateTag(@Valid Tag tag, BindingResult result, Long id, RedirectAttributes attributes)
    {
        if(tagService.getTagByName(tag.getName()).size() != 0)
        {
            result.rejectValue("name","nameError","不能重复添加");
        }
        if(result.hasErrors())
        {
            return "/admin/tags-input";
        }
        int i = tagService.updateTag(id,tag);
        if (i == 0)
        {
            attributes.addFlashAttribute("message","操作失败!");
        }
        else
        {
            attributes.addFlashAttribute("message","操作成功!");
        }
        return "redirect:/admin/tags";
    }

//    @RequestMapping("/types/{id}/input")
}
