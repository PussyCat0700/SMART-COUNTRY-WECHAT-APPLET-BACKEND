package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Comment;
import com.miniprogram.zhihuicunwu.dao.CommentDao;
import com.miniprogram.zhihuicunwu.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 21:32:17
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Integer commentId) {
        return this.commentDao.queryById(commentId);
    }
    
    /**
     * 通过任意字段查询数据列表
     *
     * @param comment 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<Comment> queryAllByAny(Comment comment){
        return this.commentDao.queryAllByAny(comment);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        this.commentDao.insert(comment);
        return comment;
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentDao.update(comment);
        return this.queryById(comment.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer commentId) {
        return this.commentDao.deleteById(commentId) > 0;
    }
}
