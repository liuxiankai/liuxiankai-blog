package com.liuxiankai.blog.service;

import com.liuxiankai.blog.dao.CommentRepository;
import com.liuxiankai.blog.po.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentRepository commentRepository;

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
