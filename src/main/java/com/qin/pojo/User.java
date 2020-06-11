package com.qin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: my-blog
 * @description: 用户实体类
 * @author: qinda
 * @create: 2020-04-10 14:25
 **/
@Data
@NoArgsConstructor
public class User {
    private Long id;    //主键id
    private String nickname;//昵称
    private String username;//用户名
    private String password;//密码
    private String email;//邮箱
    private String avatar;//头像
    private Integer type;//类型
    private Date creatTime;//创建时间
    private Date updateTime;//更新时间

    private List<Blog> users = new ArrayList<>();

}
