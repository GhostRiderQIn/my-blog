package com.qin.service;

import com.qin.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {
    void addType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id, Type type);

    void delType(Long id);
}
