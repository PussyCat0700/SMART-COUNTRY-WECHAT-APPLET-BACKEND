package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2022-06-05 14:30:12
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = -11418064987607015L;
    
    private Integer commentId;
    
    private Integer mid;
    
    private Integer uid;
    
    private Integer replyUid;
    
    private String content;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getReplyUid() {
        return replyUid;
    }

    public void setReplyUid(Integer replyUid) {
        this.replyUid = replyUid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

