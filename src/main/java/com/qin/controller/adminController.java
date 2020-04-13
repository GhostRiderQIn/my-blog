package com.qin.controller;

import com.qin.pojo.User;
import com.qin.service.UserService;
import com.qin.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @program: my-blog
 * @description: 后台用户登陆controller
 * @author: qinda
 * @create: 2020-04-13 18:23
 **/
@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String toLoginPage()
    {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes  attributes )
    {
        User user = userService.checkUser(username, MD5Util.getMD5(password,16));
        if(user != null)
        {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }
        else
        {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
