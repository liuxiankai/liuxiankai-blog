package com.liuxiankai.blog.web;


import com.liuxiankai.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;
    @GetMapping("/archives")
    public String achives(Model model){
        model.addAttribute("archiveMap",blogService.achiveBlog());
        model.addAttribute("blogCount",blogService.blogCount());
        return "archives";
    }

}
