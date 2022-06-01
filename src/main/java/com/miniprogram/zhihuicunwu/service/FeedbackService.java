package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Feedback;

/**
 * (Feedback)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface FeedbackService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Feedback queryById(Integer uid);

    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    Feedback insert(Feedback feedback);

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    Feedback update(Feedback feedback);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

}
