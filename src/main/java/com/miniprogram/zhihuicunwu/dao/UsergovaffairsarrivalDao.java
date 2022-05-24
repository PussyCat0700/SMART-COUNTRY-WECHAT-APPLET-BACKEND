package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairsarrival;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Usergovaffairsarrival)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-24 17:56:24
 */
public interface UsergovaffairsarrivalDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gaaid 主键
     * @return 实例对象
     */
    Usergovaffairsarrival queryById(Integer gaaid);

    /**
     * 查询指定行数据
     *
     * @param usergovaffairsarrival 查询条件
     * @param pageable              分页对象
     * @return 对象列表
     */
    List<Usergovaffairsarrival> queryAllByLimit(Usergovaffairsarrival usergovaffairsarrival, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param usergovaffairsarrival 查询条件
     * @return 总行数
     */
    long count(Usergovaffairsarrival usergovaffairsarrival);

    /**
     * 新增数据
     *
     * @param usergovaffairsarrival 实例对象
     * @return 影响行数
     */
    int insert(Usergovaffairsarrival usergovaffairsarrival);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Usergovaffairsarrival> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Usergovaffairsarrival> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Usergovaffairsarrival> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Usergovaffairsarrival> entities);

    /**
     * 修改数据
     *
     * @param usergovaffairsarrival 实例对象
     * @return 影响行数
     */
    int update(Usergovaffairsarrival usergovaffairsarrival);

    /**
     * 通过主键删除数据
     *
     * @param gaaid 主键
     * @return 影响行数
     */
    int deleteById(Integer gaaid);

}

