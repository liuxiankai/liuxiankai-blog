package com.liuxiankai.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuxiankai
 */

@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blogManage")
    public String blogManage(){
        return "admin/blog-manage";
    }
}
