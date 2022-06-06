package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Comment;
import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2022-06-06 21:32:17
 */
public interface CommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    Comment queryById(Integer commentId);

    /**
     * 通过任意字段查询数据列表
     *
     * @param comment 实例对象
     * @return 实例对象列表
     */
    List<Comment> queryAllByAny(Comment comment);
    
    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer commentId);

}
