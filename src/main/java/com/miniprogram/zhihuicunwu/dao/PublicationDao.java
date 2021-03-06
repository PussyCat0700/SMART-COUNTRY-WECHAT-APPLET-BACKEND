package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Publication;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Publication)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-08 21:19:32
 */
public interface PublicationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Publication queryById(Integer pid);

    List<Publication> queryByDid(Integer did);

    //根据标题模糊查询
    List<Publication> queryFuzzyByTitle(String keywords, Integer cid);

    /**
     * 查询指定行数据
     *
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Publication> queryAllByLimit(@Param("pageable") Pageable pageable, @Param("cid") Integer cid);

    /**
     * 任意查询（列表）
     * @param publication 查询条件
     * @return 对象列表
     */
    List<Publication> queryAllByAny(Publication publication);
     
    /**
     * 统计总行数
     *
     * @param publication 查询条件
     * @return 总行数
     */
    long count(Publication publication);

    int countAll();

    /**
     * 新增数据
     *
     * @param publication 实例对象
     * @return 影响行数
     */
    int insert(Publication publication);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Publication> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Publication> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Publication> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Publication> entities);

    /**
     * 修改数据
     *
     * @param publication 实例对象
     * @return 影响行数
     */
    int update(Publication publication);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 影响行数
     */
    int deleteById(Integer pid);

}

