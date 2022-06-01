package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Govaffairsspot;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Govaffairsspot)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface GovaffairsspotDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gasid 主键
     * @return 实例对象
     */
    Govaffairsspot queryById(Integer gasid);

    /**
     * 查询指定行数据
     *
     * @param govaffairsspot 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Govaffairsspot> queryAllByLimit(Govaffairsspot govaffairsspot, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param govaffairsspot 查询条件
     * @return 总行数
     */
    long count(Govaffairsspot govaffairsspot);

    /**
     * 新增数据
     *
     * @param govaffairsspot 实例对象
     * @return 影响行数
     */
    int insert(Govaffairsspot govaffairsspot);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Govaffairsspot> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Govaffairsspot> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Govaffairsspot> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Govaffairsspot> entities);

    /**
     * 修改数据
     *
     * @param govaffairsspot 实例对象
     * @return 影响行数
     */
    int update(Govaffairsspot govaffairsspot);

    /**
     * 通过主键删除数据
     *
     * @param gasid 主键
     * @return 影响行数
     */
    int deleteById(Integer gasid);

}

