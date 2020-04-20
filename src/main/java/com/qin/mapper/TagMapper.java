package com.qin.mapper;

import java.util.List;

import com.qin.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qin.pojo.Type;


@Mapper
@Repository
public interface TagMapper {
    int addTag(Tag tag);

    Tag getTag(@Param("id") Long id);

    List<Tag> selectPage();

    List<Tag> getAllTags();

    int updateTag(@Param("id") Long id, @Param("tag") Tag tag);

    int delTag(@Param("id") Long id);

    List<Tag> getTagByName(@Param("name") String name);

    List<Tag> getTagTopList(@Param("size") Integer size);
}
