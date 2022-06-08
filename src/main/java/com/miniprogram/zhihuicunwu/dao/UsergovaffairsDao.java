package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairs;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Usergovaffairs)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 15:49:46
 */
public interface UsergovaffairsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param usergaid 主键
     * @return 实例对象
     */
    Usergovaffairs queryById(Integer usergaid);

    List<Usergovaffairs> queryByDid(Integer did);

    List<Usergovaffairs> queryByUid(Integer uid);

    /**
     * 查询指定行数据
     *
     * @param usergovaffairs 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Usergovaffairs> queryAllByLimit(Usergovaffairs usergovaffairs, @Param("pageable") Pageable pageable);

    /**
     * 任意查询（列表）
     * @param usergovaffairs 查询条件
     * @return 对象列表
     */
    List<Usergovaffairs> queryAllByAny(Usergovaffairs usergovaffairs);
     
    /**
     * 统计总行数
     *
     * @param usergovaffairs 查询条件
     * @return 总行数
     */
    long count(Usergovaffairs usergovaffairs);

    /**
     * 新增数据
     *
     * @param usergovaffairs 实例对象
     * @return 影响行数
     */
    int insert(Usergovaffairs usergovaffairs);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Usergovaffairs> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Usergovaffairs> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Usergovaffairs> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Usergovaffairs> entities);

    /**
     * 修改数据
     *
     * @param usergovaffairs 实例对象
     * @return 影响行数
     */
    int update(Usergovaffairs usergovaffairs);

    /**
     * 通过主键删除数据
     *
     * @param usergaid 主键
     * @return 影响行数
     */
    int deleteById(Integer usergaid);

}

