package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Feedbackcomment)实体类
 *
 * @author makejava
 * @since 2022-06-18 11:19:00
 */
public class Feedbackcomment implements Serializable {
    private static final long serialVersionUID = 992000658124866137L;
    
    private Integer commentId;
    
    private Integer fid;
    
    private Integer uid;
    
    private Integer replyUid;
    
    private String content;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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

