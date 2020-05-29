package com.liuxiankai.blog.service;

import com.liuxiankai.blog.po.Comment;

import java.util.List;

public interface CommentService {
    public void addComment(Comment comment);

    public List<Comment> listCommentByBlogId(Long blogId);

    public Comment saveComment(Comment comment);
}
