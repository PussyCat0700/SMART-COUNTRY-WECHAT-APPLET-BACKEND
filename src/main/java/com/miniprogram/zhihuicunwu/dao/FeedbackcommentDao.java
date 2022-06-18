package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Feedbackcomment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Feedbackcomment)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-18 11:19:00
 */
public interface FeedbackcommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    Feedbackcomment queryById(Integer commentId);

    /**
     * 查询指定行数据
     *
     * @param feedbackcomment 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Feedbackcomment> queryAllByLimit(Feedbackcomment feedbackcomment, @Param("pageable") Pageable pageable);

    /**
     * 任意查询（列表）
     * @param feedbackcomment 查询条件
     * @return 对象列表
     */
    List<Feedbackcomment> queryAllByAny(Feedbackcomment feedbackcomment);
     
    /**
     * 统计总行数
     *
     * @param feedbackcomment 查询条件
     * @return 总行数
     */
    long count(Feedbackcomment feedbackcomment);

    /**
     * 新增数据
     *
     * @param feedbackcomment 实例对象
     * @return 影响行数
     */
    int insert(Feedbackcomment feedbackcomment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Feedbackcomment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Feedbackcomment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Feedbackcomment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Feedbackcomment> entities);

    /**
     * 修改数据
     *
     * @param feedbackcomment 实例对象
     * @return 影响行数
     */
    int update(Feedbackcomment feedbackcomment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    int deleteById(Integer commentId);

}

