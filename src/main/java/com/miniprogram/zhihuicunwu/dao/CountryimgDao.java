package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Countryimg;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Countryimg)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-07 13:21:12
 */
public interface CountryimgDao {

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    Countryimg queryById(Integer imgId);

    /**
     * 查询指定行数据
     *
     * @param countryimg 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Countryimg> queryAllByLimit(Countryimg countryimg, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param countryimg 查询条件
     * @return 总行数
     */
    long count(Countryimg countryimg);

    /**
     * 新增数据
     *
     * @param countryimg 实例对象
     * @return 影响行数
     */
    int insert(Countryimg countryimg);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Countryimg> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Countryimg> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Countryimg> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Countryimg> entities);

    /**
     * 修改数据
     *
     * @param countryimg 实例对象
     * @return 影响行数
     */
    int update(Countryimg countryimg);

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 影响行数
     */
    int deleteById(Integer imgId);

}

