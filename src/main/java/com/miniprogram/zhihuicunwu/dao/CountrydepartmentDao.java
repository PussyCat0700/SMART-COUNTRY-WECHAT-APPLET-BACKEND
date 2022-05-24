package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Countrydepartment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Countrydepartment)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-24 17:56:20
 */
public interface CountrydepartmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Countrydepartment queryById(Integer did);

    /**
     * 查询指定行数据
     *
     * @param countrydepartment 查询条件
     * @param pageable          分页对象
     * @return 对象列表
     */
    List<Countrydepartment> queryAllByLimit(Countrydepartment countrydepartment, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param countrydepartment 查询条件
     * @return 总行数
     */
    long count(Countrydepartment countrydepartment);

    /**
     * 新增数据
     *
     * @param countrydepartment 实例对象
     * @return 影响行数
     */
    int insert(Countrydepartment countrydepartment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Countrydepartment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Countrydepartment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Countrydepartment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Countrydepartment> entities);

    /**
     * 修改数据
     *
     * @param countrydepartment 实例对象
     * @return 影响行数
     */
    int update(Countrydepartment countrydepartment);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 影响行数
     */
    int deleteById(Integer did);

}

