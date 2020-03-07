package com.liuxiankai.blog.service;

import com.liuxiankai.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author liuxiankai
 */
public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id,Type type);

    void delType(Long id);

    Type getTypeByName(String name);
}
