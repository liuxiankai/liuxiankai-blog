package com.liuxiankai.blog.service;

import com.liuxiankai.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author liuxiankai
 */
public interface TagService {
    Tag saveType(Tag tag);

    Tag getType(Long id);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id,Tag type);

    void delTag(Long id);

    Tag getTagByName(String name);
}
