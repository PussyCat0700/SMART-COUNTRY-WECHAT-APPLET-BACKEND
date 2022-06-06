package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Publicationattach;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Publicationattach)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-06 16:53:53
 */
public interface PublicationattachDao {

    /**
     * 通过ID查询单条数据
     *
     * @param attachId 主键
     * @return 实例对象
     */
    Publicationattach queryById(Integer attachId);

    /**
     * 查询指定行数据
     *
     * @param publicationattach 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Publicationattach> queryAllByLimit(Publicationattach publicationattach, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param publicationattach 查询条件
     * @return 总行数
     */
    long count(Publicationattach publicationattach);

    /**
     * 新增数据
     *
     * @param publicationattach 实例对象
     * @return 影响行数
     */
    int insert(Publicationattach publicationattach);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Publicationattach> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Publicationattach> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Publicationattach> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Publicationattach> entities);

    /**
     * 修改数据
     *
     * @param publicationattach 实例对象
     * @return 影响行数
     */
    int update(Publicationattach publicationattach);

    /**
     * 通过主键删除数据
     *
     * @param attachId 主键
     * @return 影响行数
     */
    int deleteById(Integer attachId);

}

