package com.liuxiankai.blog.web;


import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liuxiankai
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
////        int i = 9/0;
//        String blog = null;
//        if (blog == null)  {
//            throw new NotFoundException("页面找不到");
//        }
        System.out.println("------------index------------");
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
////        int i = 9/0;
//        String blog = null;
//        if (blog == null)  {
//            throw new NotFoundException("页面找不到");
//        }
        System.out.println("------------blog------------");
        return "blog";
    }
}
