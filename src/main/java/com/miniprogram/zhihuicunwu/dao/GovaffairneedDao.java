package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Govaffairneed;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Govaffairneed)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-03 11:40:55
 */
public interface GovaffairneedDao {

    /**
     * 通过ID查询单条数据
     *
     * @param needgovaffairid 主键
     * @return 实例对象
     */
    Govaffairneed queryById(Integer needgovaffairid);

    /**
     * 查询指定行数据
     *
     * @param govaffairneed 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Govaffairneed> queryAllByLimit(Govaffairneed govaffairneed, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param govaffairneed 查询条件
     * @return 总行数
     */
    long count(Govaffairneed govaffairneed);

    /**
     * 新增数据
     *
     * @param govaffairneed 实例对象
     * @return 影响行数
     */
    int insert(Govaffairneed govaffairneed);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Govaffairneed> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Govaffairneed> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Govaffairneed> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Govaffairneed> entities);

    /**
     * 修改数据
     *
     * @param govaffairneed 实例对象
     * @return 影响行数
     */
    int update(Govaffairneed govaffairneed);

    /**
     * 通过主键删除数据
     *
     * @param needgovaffairid 主键
     * @return 影响行数
     */
    int deleteById(Integer needgovaffairid);

}

