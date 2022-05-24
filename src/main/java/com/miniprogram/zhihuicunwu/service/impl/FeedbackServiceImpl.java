package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Feedback;
import com.miniprogram.zhihuicunwu.dao.FeedbackDao;
import com.miniprogram.zhihuicunwu.service.FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Feedback)表服务实现类
 *
 * @author makejava
 * @since 2022-05-24 17:56:22
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackDao feedbackDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public Feedback queryById(Integer uid) {
        return this.feedbackDao.queryById(uid);
    }

    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    public Feedback insert(Feedback feedback) {
        this.feedbackDao.insert(feedback);
        return feedback;
    }

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    public Feedback update(Feedback feedback) {
        this.feedbackDao.update(feedback);
        return this.queryById(feedback.getUid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uid) {
        return this.feedbackDao.deleteById(uid) > 0;
    }
}
