package com.liuxiankai.blog.service;

import com.liuxiankai.blog.po.Blog;
import com.liuxiankai.blog.po.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author liuxiankai
 */
public interface BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    Page<Blog> listBlog(Pageable pageable,String query);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String,List<Blog>> achiveBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

    Long blogCount();
}
