package com.qin.mapper;

import com.qin.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface TypeMapper {
    int addType(Type type);

    Type getType(@Param("id") Long id);

    List<Type> selectPage();

    int updateType(@Param("id") Long id,@Param("type") Type type);

    int delType(@Param("id") Long id);

    List<Type> getTypeByName(@Param("name") String name);
}
