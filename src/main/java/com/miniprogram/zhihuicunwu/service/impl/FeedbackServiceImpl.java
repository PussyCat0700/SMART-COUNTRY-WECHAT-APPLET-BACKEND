package com.miniprogram.zhihuicunwu.service.impl;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Feedback;
import com.miniprogram.zhihuicunwu.dao.FeedbackDao;
import com.miniprogram.zhihuicunwu.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (Feedback)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
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

    @Override
    public List<Feedback> queryAll()
    {
        return this.feedbackDao.queryAll();
    }

    @Override
    public List<Feedback> queryFuzzyByContent(String content)
    {
        return this.feedbackDao.queryFuzzyByContent("[" + content + "]");
    }

    @Override
    public List<Feedback> queryFuzzyByTitle(String title)
    {
        return this.feedbackDao.queryFuzzyByContent("[" + title + "]");
    }

    @Override
    public List<Feedback> queryFeedbackByUid(int uid)
    {
        return this.feedbackDao.queryFeedbackByUid(uid);
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
