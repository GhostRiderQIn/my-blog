package com.qin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: my-blog
 * @description: 标签实体类
 * @author: qinda
 * @create: 2020-04-10 14:20
 **/
@Data
@NoArgsConstructor
public class Tag {
    private Long id;    //主键
    private String name;//标签名

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
