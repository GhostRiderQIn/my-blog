package com.qin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: my-blog
 * @description: 分类实体类
 * @author: qinda
 * @create: 2020-04-10 14:19
 **/
@Data
@NoArgsConstructor
public class Type {
    private Long id;  //主键
    private String name;    //分类名

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
