package com.qin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: my-blog
 * @description: 博客实体类
 * @author: qinda
 * @create: 2020-04-10 10:04
 **/
@Data
@NoArgsConstructor
public class Blog {
    private Long id;    //博客id
    private String title;   //博客标题
    private String content; //博客文本
    private String firstPicture;    //首图
    private String flag;    //原创、转载、翻译等
    private Integer views;  //浏览次数
    private boolean appreciation; //赞赏是否开启
    private boolean shareStatement; //分享是否开启
    private boolean commentAble; //评论是否开启
    private boolean published; //是否发布
    private boolean recommend; //是否推荐
    private Date creatTime; //创建时间
    private Date updateTime;  //更新时间

    //对应关系

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentAble=" + commentAble +
                ", published=" + published +
                ", recommend=" + recommend +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}