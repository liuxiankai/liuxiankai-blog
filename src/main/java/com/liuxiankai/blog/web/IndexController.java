package com.liuxiankai.blog.web;


import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuxiankai
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index() {

      
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }
}
