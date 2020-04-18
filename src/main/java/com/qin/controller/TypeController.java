package com.qin.controller;

import com.qin.pojo.PageRequest;
import com.qin.pojo.Type;
import com.qin.service.TypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

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

        if(pageRequest.getPageNum() == 0 && pageRequest.getPageSize() == 0)
        {
            pageRequest = new PageRequest();
            pageRequest.setPageNum(1);
            pageRequest.setPageSize(10);
        }
        model.addAttribute("page",typeService.listType(pageRequest));
        return "admin/types";
    }

    @RequestMapping("/types/input")
    public String toAddType(Model model)
    {
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    @RequestMapping("/types/{id}/input")
    public String toUpdateType(@PathVariable Long id, Model model)
    {
        Type type = typeService.getType(id);
        model.addAttribute("type",type);
        return "admin/types-input";
    }

    @RequestMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id,RedirectAttributes attributes)
    {
        int type = typeService.delType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }

    @PostMapping("/types")
    public String addType(@Valid Type type, BindingResult result, RedirectAttributes attributes)
    {
        if(typeService.getTypeByName(type.getName()).size() != 0)
        {
            result.rejectValue("name","nameError","不能重复添加");
        }
        if(result.hasErrors())
        {
            return "/admin/types-input";
        }
        int i = typeService.addType(type);
        if (i == 0)
        {
            attributes.addFlashAttribute("message","操作失败!");
        }
        else
        {
            attributes.addFlashAttribute("message","操作成功!");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String updateType(@Valid Type type, BindingResult result, Long id, RedirectAttributes attributes)
    {
        if(typeService.getTypeByName(type.getName()).size() != 0)
        {
            result.rejectValue("name","nameError","不能重复添加");
        }
        if(result.hasErrors())
        {
            return "/admin/types-input";
        }
        int i = typeService.updateType(id,type);
        if (i == 0)
        {
            attributes.addFlashAttribute("message","操作失败!");
        }
        else
        {
            attributes.addFlashAttribute("message","操作成功!");
        }
        return "redirect:/admin/types";
    }

//    @RequestMapping("/types/{id}/input")
}
