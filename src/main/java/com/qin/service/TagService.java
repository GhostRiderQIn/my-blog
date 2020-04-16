package com.qin.service;

import java.util.List;

import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;
import com.qin.pojo.Tag;
import com.qin.pojo.Type;

public interface TagService {
    int addTag(Tag tag);

    Tag getTag(Long id);

    PageResult listTag(PageRequest pageRequest);

    List<Tag> getTagByName(String name);

    int updateTag(Long id, Tag tag);

    int delTag(Long id);
}
