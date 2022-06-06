package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Application;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Application)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-06 11:42:26
 */
public interface ApplicationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param applicationId 主键
     * @return 实例对象
     */
    Application queryById(Integer applicationId);

    /**
     * 查询指定行数据
     *
     * @param application 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Application> queryAllByLimit(Application application, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param application 查询条件
     * @return 总行数
     */
    long count(Application application);

    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 影响行数
     */
    int insert(Application application);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Application> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Application> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Application> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Application> entities);

    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 影响行数
     */
    int update(Application application);

    /**
     * 通过主键删除数据
     *
     * @param applicationId 主键
     * @return 影响行数
     */
    int deleteById(Integer applicationId);

}

