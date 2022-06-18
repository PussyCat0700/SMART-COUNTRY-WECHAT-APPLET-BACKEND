package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Feedbackcomment;
import java.util.List;

/**
 * (Feedbackcomment)表服务接口
 *
 * @author makejava
 * @since 2022-06-18 11:19:00
 */
public interface FeedbackcommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    Feedbackcomment queryById(Integer commentId);

    /**
     * 通过任意字段查询数据列表
     *
     * @param feedbackcomment 实例对象
     * @return 实例对象列表
     */
    List<Feedbackcomment> queryAllByAny(Feedbackcomment feedbackcomment);
    
    /**
     * 新增数据
     *
     * @param feedbackcomment 实例对象
     * @return 实例对象
     */
    Feedbackcomment insert(Feedbackcomment feedbackcomment);

    /**
     * 修改数据
     *
     * @param feedbackcomment 实例对象
     * @return 实例对象
     */
    Feedbackcomment update(Feedbackcomment feedbackcomment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer commentId);

}
