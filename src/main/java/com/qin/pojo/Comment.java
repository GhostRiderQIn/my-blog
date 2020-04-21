package com.qin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: my-blog
 * @description: 评论实体类
 * @author: qinda
 * @create: 2020-04-10 14:21
 **/
@Data
@NoArgsConstructor
public class Comment
{
    private Long id;    //主键id
    private String nickname;//昵称
    private String email;//邮箱
    private String content;//评论内容
    private String avatar;//图片地址或base64
    private Date creatTime;//评论时间

    private Blog blog;
    private Long blogId;

    private List<Comment> replyComments = new ArrayList<>();

    private Comment parentComment;
    private Long parentCommentId;
    private Long rootCommentId;


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", creatTime=" + creatTime +
                ", blog=" + blog +
                ", blogId=" + blogId +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                ", parentCommentId=" + parentCommentId +
                ", rootCommentId=" + rootCommentId +
                '}';
    }
}
