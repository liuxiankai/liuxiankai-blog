package com.liuxiankai.blog.dao;

import com.liuxiankai.blog.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuxiankai
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

}
