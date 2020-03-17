package com.liuxiankai.blog.dao;

import com.liuxiankai.blog.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);


    @Query("select b from Blog b where b.title LIKE %:query% or b.content LIKE %:query%")
    Page<Blog> findByQuery(String query,Pageable pageable);
}
