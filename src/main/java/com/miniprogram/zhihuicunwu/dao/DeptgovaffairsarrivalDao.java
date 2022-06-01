package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairsarrival;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Deptgovaffairsarrival)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface DeptgovaffairsarrivalDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gaaid 主键
     * @return 实例对象
     */
    Deptgovaffairsarrival queryById(Integer gaaid);

    /**
     * 查询指定行数据
     *
     * @param deptgovaffairsarrival 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Deptgovaffairsarrival> queryAllByLimit(Deptgovaffairsarrival deptgovaffairsarrival, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param deptgovaffairsarrival 查询条件
     * @return 总行数
     */
    long count(Deptgovaffairsarrival deptgovaffairsarrival);

    /**
     * 新增数据
     *
     * @param deptgovaffairsarrival 实例对象
     * @return 影响行数
     */
    int insert(Deptgovaffairsarrival deptgovaffairsarrival);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Deptgovaffairsarrival> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Deptgovaffairsarrival> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Deptgovaffairsarrival> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Deptgovaffairsarrival> entities);

    /**
     * 修改数据
     *
     * @param deptgovaffairsarrival 实例对象
     * @return 影响行数
     */
    int update(Deptgovaffairsarrival deptgovaffairsarrival);

    /**
     * 通过主键删除数据
     *
     * @param gaaid 主键
     * @return 影响行数
     */
    int deleteById(Integer gaaid);

}

