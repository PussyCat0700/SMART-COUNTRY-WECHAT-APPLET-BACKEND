package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairsspot;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Usergovaffairsspot)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-24 17:56:25
 */
public interface UsergovaffairsspotDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gasid 主键
     * @return 实例对象
     */
    Usergovaffairsspot queryById(Integer gasid);

    /**
     * 查询指定行数据
     *
     * @param usergovaffairsspot 查询条件
     * @param pageable           分页对象
     * @return 对象列表
     */
    List<Usergovaffairsspot> queryAllByLimit(Usergovaffairsspot usergovaffairsspot, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param usergovaffairsspot 查询条件
     * @return 总行数
     */
    long count(Usergovaffairsspot usergovaffairsspot);

    /**
     * 新增数据
     *
     * @param usergovaffairsspot 实例对象
     * @return 影响行数
     */
    int insert(Usergovaffairsspot usergovaffairsspot);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Usergovaffairsspot> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Usergovaffairsspot> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Usergovaffairsspot> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Usergovaffairsspot> entities);

    /**
     * 修改数据
     *
     * @param usergovaffairsspot 实例对象
     * @return 影响行数
     */
    int update(Usergovaffairsspot usergovaffairsspot);

    /**
     * 通过主键删除数据
     *
     * @param gasid 主键
     * @return 影响行数
     */
    int deleteById(Integer gasid);

}

