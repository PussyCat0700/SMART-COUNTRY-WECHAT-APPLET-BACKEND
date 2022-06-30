package com.miniprogram.zhihuicunwu.service;

import java.util.List;
import com.miniprogram.zhihuicunwu.entity.Feedback;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

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
     * @param fid 主键
     * @return 实例对象
     */
    Feedback queryById(Integer fid);

    List<Feedback> queryByPid(Integer pid);

    //查询所有数据
    List<Feedback> queryAll();

    //模糊查询
    List<Feedback> queryFuzzyByContent(String content);

    //模糊查询
    List<Feedback> queryFuzzyByTitle(String title);

    //查询我的反馈（根据uid查询）
    List<Feedback> queryFeedbackByUid(int uid);

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
