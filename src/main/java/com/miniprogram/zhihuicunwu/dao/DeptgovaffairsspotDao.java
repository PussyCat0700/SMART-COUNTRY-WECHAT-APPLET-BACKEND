package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairsspot;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Deptgovaffairsspot)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-24 17:56:21
 */
public interface DeptgovaffairsspotDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gasid 主键
     * @return 实例对象
     */
    Deptgovaffairsspot queryById(Integer gasid);

    /**
     * 查询指定行数据
     *
     * @param deptgovaffairsspot 查询条件
     * @param pageable           分页对象
     * @return 对象列表
     */
    List<Deptgovaffairsspot> queryAllByLimit(Deptgovaffairsspot deptgovaffairsspot, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param deptgovaffairsspot 查询条件
     * @return 总行数
     */
    long count(Deptgovaffairsspot deptgovaffairsspot);

    /**
     * 新增数据
     *
     * @param deptgovaffairsspot 实例对象
     * @return 影响行数
     */
    int insert(Deptgovaffairsspot deptgovaffairsspot);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Deptgovaffairsspot> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Deptgovaffairsspot> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Deptgovaffairsspot> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Deptgovaffairsspot> entities);

    /**
     * 修改数据
     *
     * @param deptgovaffairsspot 实例对象
     * @return 影响行数
     */
    int update(Deptgovaffairsspot deptgovaffairsspot);

    /**
     * 通过主键删除数据
     *
     * @param gasid 主键
     * @return 影响行数
     */
    int deleteById(Integer gasid);

}

