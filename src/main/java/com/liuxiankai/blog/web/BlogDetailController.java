package com.liuxiankai.blog.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liuxiankai.blog.po.Comment;
import com.liuxiankai.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/blog")
public class BlogDetailController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public String addComment(HttpServletRequest request){
        String[] comment = request.getParameterValues("comment");
        System.out.println(comment);
        return null;
    }
}
