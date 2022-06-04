package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Feedback;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * (Feedback)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface FeedbackDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Feedback queryById(Integer uid);

    /**
     * 查询指定行数据
     *
     * @param feedback 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Feedback> queryAllByLimit(Feedback feedback, @Param("pageable") Pageable pageable);

    //查询所有的数据
    List<Feedback> queryAll();

    //模糊查询
    List<Feedback> queryFuzzyByContent(String content);

    //查询我的反馈（根据uid查询）
    List<Feedback> queryFeedbackByUid(int uid);

    /**
     * 统计总行数
     *
     * @param feedback 查询条件
     * @return 总行数
     */
    long count(Feedback feedback);

    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 影响行数
     */
    int insert(Feedback feedback);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Feedback> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Feedback> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Feedback> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Feedback> entities);

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 影响行数
     */
    int update(Feedback feedback);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 影响行数
     */
    int deleteById(Integer uid);

}

