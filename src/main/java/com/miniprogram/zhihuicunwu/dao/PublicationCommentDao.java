package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.PublicationComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (PublicationComment)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 15:29:08
 */
public interface PublicationCommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    PublicationComment queryById(Integer commentId);

    /**
     * 查询指定行数据
     *
     * @param publicationComment 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PublicationComment> queryAllByLimit(PublicationComment publicationComment, @Param("pageable") Pageable pageable);

    /**
     * 任意查询（列表）
     * @param publicationComment 查询条件
     * @return 对象列表
     */
    List<PublicationComment> queryAllByAny(PublicationComment publicationComment);
     
    /**
     * 统计总行数
     *
     * @param publicationComment 查询条件
     * @return 总行数
     */
    long count(PublicationComment publicationComment);

    /**
     * 新增数据
     *
     * @param publicationComment 实例对象
     * @return 影响行数
     */
    int insert(PublicationComment publicationComment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PublicationComment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PublicationComment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PublicationComment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PublicationComment> entities);

    /**
     * 修改数据
     *
     * @param publicationComment 实例对象
     * @return 影响行数
     */
    int update(PublicationComment publicationComment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    int deleteById(Integer commentId);

}

