package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Feedbackcomment;
import com.miniprogram.zhihuicunwu.dao.FeedbackcommentDao;
import com.miniprogram.zhihuicunwu.service.FeedbackcommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Feedbackcomment)表服务实现类
 *
 * @author makejava
 * @since 2022-06-18 11:19:00
 */
@Service("feedbackcommentService")
public class FeedbackcommentServiceImpl implements FeedbackcommentService {
    @Resource
    private FeedbackcommentDao feedbackcommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public Feedbackcomment queryById(Integer commentId) {
        return this.feedbackcommentDao.queryById(commentId);
    }
    
    /**
     * 通过任意字段查询数据列表
     *
     * @param feedbackcomment 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<Feedbackcomment> queryAllByAny(Feedbackcomment feedbackcomment){
        return this.feedbackcommentDao.queryAllByAny(feedbackcomment);
    }

    /**
     * 新增数据
     *
     * @param feedbackcomment 实例对象
     * @return 实例对象
     */
    @Override
    public Feedbackcomment insert(Feedbackcomment feedbackcomment) {
        this.feedbackcommentDao.insert(feedbackcomment);
        return feedbackcomment;
    }

    /**
     * 修改数据
     *
     * @param feedbackcomment 实例对象
     * @return 实例对象
     */
    @Override
    public Feedbackcomment update(Feedbackcomment feedbackcomment) {
        this.feedbackcommentDao.update(feedbackcomment);
        return this.queryById(feedbackcomment.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer commentId) {
        return this.feedbackcommentDao.deleteById(commentId) > 0;
    }
}
