package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Publicationpic;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Publicationpic)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-06 16:54:05
 */
public interface PublicationpicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    Publicationpic queryById(Integer imgId);

    List<Publicationpic> queryByPid(Integer pid);

    /**
     * 查询指定行数据
     *
     * @param publicationpic 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Publicationpic> queryAllByLimit(Publicationpic publicationpic, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param publicationpic 查询条件
     * @return 总行数
     */
    long count(Publicationpic publicationpic);

    /**
     * 新增数据
     *
     * @param publicationpic 实例对象
     * @return 影响行数
     */
    int insert(Publicationpic publicationpic);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Publicationpic> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Publicationpic> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Publicationpic> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Publicationpic> entities);

    /**
     * 修改数据
     *
     * @param publicationpic 实例对象
     * @return 影响行数
     */
    int update(Publicationpic publicationpic);

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 影响行数
     */
    int deleteById(Integer imgId);

}

