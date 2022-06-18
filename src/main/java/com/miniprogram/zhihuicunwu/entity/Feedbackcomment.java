package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Feedbackcomment)实体类
 *
 * @author makejava
 * @since 2022-06-12 16:23:47
 */
public class Feedbackcomment implements Serializable {
    private static final long serialVersionUID = 898359825707473224L;
    
    private Integer commentId;
    
    private Integer pid;
    
    private Integer uid;
    
    private Integer replyUid;
    
    private String content;
    
    private Integer replyCommentId;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Integer getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Integer replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

}

