package com.liuxiankai.blog.web;


import com.liuxiankai.blog.po.User;
import com.liuxiankai.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ConsumerLoginController {

    @Autowired
    private UserService userService;
    @GetMapping("/loginList")
    public String loginList(){

        return "consumer_login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes){
        User user = userService.checkConsumerUser(username,password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("consumer",user);
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/loginList";
        }
    }

    @PostMapping("/registerList")
    public String registerList(){
        return "consumer_register";
    }

}
