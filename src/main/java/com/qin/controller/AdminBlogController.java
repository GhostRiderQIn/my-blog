package com.qin.controller;

import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.pojo.User;
import com.qin.service.BlogService;
import com.qin.service.TagService;
import com.qin.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private TagService tagService;
    @GetMapping("/blogs/input")
    public String toAddBlog(Model model)
    {
        Blog blog = new Blog();
        blog.setFlag("原创");
        model.addAttribute("types",typeService.getAllTypes());
        model.addAttribute("blog",blog);
        model.addAttribute("tags",tagService.getAllTags());
        return "admin/blogs-input";
    }

    @GetMapping("/blogs")
    public String blogs(PageRequest pageRequest, Blog blog, Model model,HttpSession session)
    {
        System.out.println(blog);
        blog.setUser((User) session.getAttribute("user"));
        blog.setUserId(blog.getUser().getId());
        if (pageRequest.getPageSize() == 0 && pageRequest.getPageNum() == 0)
        {
            pageRequest.setPageSize(5);
            pageRequest.setPageNum(1);
        }
        model.addAttribute("types",typeService.getAllTypes());
        model.addAttribute("page",blogService.listBlog(pageRequest,blog));
        return "admin/blogs";
    }
    @RequestMapping("/blogs/search")
    public String search(PageRequest pageRequest, Blog blog, Model model, HttpSession session)
    {
        User user = (User) session.getAttribute("user");
        blog.setUserId(user.getId());
        if (pageRequest.getPageSize() == 0 && pageRequest.getPageNum() == 0)
        {
            pageRequest.setPageSize(5);
            pageRequest.setPageNum(1);
        }
        model.addAttribute("page",blogService.listBlog(pageRequest,blog));
        return "admin/blogs :: blogList";
    }
//
    @RequestMapping("/blogs/{id}/input")
    public String update(@PathVariable Long id, Model model)
    {
        model.addAttribute("types",typeService.getAllTypes());
        model.addAttribute("tags",tagService.getAllTags());
        Blog blog = blogService.getBlogById(id);
        blog.tagsToTagIds();
        System.out.println(blog.getTagIds());
        model.addAttribute("blog",blog);
        System.out.println(blog);
        return "admin/blogs-input";
    }

    @RequestMapping("/blogs/{id}/delete")
    public String del(@PathVariable Long id, RedirectAttributes attributes)
    {
        int blog = blogService.delBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }

    @PostMapping("/blogs")
    public String add(@Valid Blog blog, BindingResult result, RedirectAttributes attributes, HttpSession session)
    {
        System.out.println(blog);
        blog.setUser((User) session.getAttribute("user"));
        if(result.hasErrors())
        {
            return "/admin/blogs-input";
        }
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.setTags(tagService.getTagsByIds(blog.getTagIds()));
        blog.setUserId(blog.getUser().getId());
        int i = blogService.addBlog(blog);
        if (i == 0)
            attributes.addFlashAttribute("message","操作失败");
        else
            attributes.addFlashAttribute("message","操作成功");
        return "redirect:/admin/blogs";
    }

    @PostMapping("/blogs/{id}")
    public String update(@Valid Blog blog, BindingResult result,@PathVariable Long id, RedirectAttributes attributes, HttpSession session)
    {
        blog.setUser((User) session.getAttribute("user"));
        if(result.hasErrors())
        {
            return "/admin/blogs-input";
        }

        blog.setTags(tagService.getTagsByIds(blog.getTagIds()));
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.setUserId(blog.getUser().getId());
        int i = blogService.updateBlog(id,blog);
        if (i == 0)
            attributes.addFlashAttribute("message","操作失败");
        else
            attributes.addFlashAttribute("message","操作成功");
        return "redirect:/admin/blogs";
    }

}
