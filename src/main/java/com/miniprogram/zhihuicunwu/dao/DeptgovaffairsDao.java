package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairs;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Deptgovaffairs)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-06 22:09:52
 */
public interface DeptgovaffairsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param deptgovid 主键
     * @return 实例对象
     */
    Deptgovaffairs queryById(Integer deptgovid);

    /**
     * 查询指定行数据
     *
     * @param deptgovaffairs 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Deptgovaffairs> queryAllByLimit(Deptgovaffairs deptgovaffairs, @Param("pageable") Pageable pageable);

    /**
     * 任意查询（列表）
     * @param deptgovaffairs 查询条件
     * @return 对象列表
     */
    List<Deptgovaffairs> queryAllByAny(Deptgovaffairs deptgovaffairs);
     
    /**
     * 统计总行数
     *
     * @param deptgovaffairs 查询条件
     * @return 总行数
     */
    long count(Deptgovaffairs deptgovaffairs);

    /**
     * 新增数据
     *
     * @param deptgovaffairs 实例对象
     * @return 影响行数
     */
    int insert(Deptgovaffairs deptgovaffairs);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Deptgovaffairs> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Deptgovaffairs> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Deptgovaffairs> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Deptgovaffairs> entities);

    /**
     * 修改数据
     *
     * @param deptgovaffairs 实例对象
     * @return 影响行数
     */
    int update(Deptgovaffairs deptgovaffairs);

    /**
     * 通过主键删除数据
     *
     * @param deptgovid 主键
     * @return 影响行数
     */
    int deleteById(Integer deptgovid);

}

