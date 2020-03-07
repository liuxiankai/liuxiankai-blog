package com.liuxiankai.blog.dao;

import com.liuxiankai.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuxiankai
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);
}
