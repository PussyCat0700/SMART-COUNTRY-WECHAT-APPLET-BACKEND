package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (PublicationComment)实体类
 *
 * @author makejava
 * @since 2022-06-16 15:29:09
 */
public class PublicationComment implements Serializable {
    private static final long serialVersionUID = 282340583809662876L;
    
    private Integer commentId;
    
    private Integer pid;
    
    private Integer uid;
    
    private Integer replyUid;
    
    private String content;
    
    private Integer rootCommentId;


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

    public Integer getRootCommentId() {
        return rootCommentId;
    }

    public void setRootCommentId(Integer rootCommentId) {
        this.rootCommentId = rootCommentId;
    }

}

