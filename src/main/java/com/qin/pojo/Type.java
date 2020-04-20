package com.qin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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
    @NotBlank(message = "分类名称不能为空")
    private String name;    //分类名


    private List<Blog> blogs = new ArrayList<Blog>();
    private Integer blogsCount;

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
