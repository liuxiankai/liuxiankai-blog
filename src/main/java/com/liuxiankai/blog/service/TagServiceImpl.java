package com.liuxiankai.blog.service;

import com.liuxiankai.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author liuxiankai
 */
public class TagServiceImpl implements TagService {
    @Override
    public Tag saveType(Tag tag) {
        return null;
    }

    @Override
    public Tag getType(Long id) {
        return null;
    }

    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return null;
    }

    @Override
    public Tag updateTag(Long id, Tag type) {
        return null;
    }

    @Override
    public void delTag(Long id) {

    }

    @Override
    public Tag getTagByName(String name) {
        return null;
    }
}
