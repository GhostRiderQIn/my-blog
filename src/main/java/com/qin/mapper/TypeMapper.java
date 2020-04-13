package com.qin.mapper;

import com.qin.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface TypeMapper {
    void addType(Type type);

    Type getType(@Param("id") Long id);

    Page<Type> listType(Pageable pageable);

    void updateType(@Param("id") Long id,@Param("type") Type type);

    void delType(Long id);
}
