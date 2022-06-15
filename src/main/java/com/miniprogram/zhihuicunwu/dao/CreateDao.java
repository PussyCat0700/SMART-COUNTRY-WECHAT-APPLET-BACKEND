package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Create;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Create)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface CreateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    Create queryById(Integer cid);

    /**
     * 查询指定行数据
     *
     * @param create 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Create> queryAllByLimit(Create create, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param create 查询条件
     * @return 总行数
     */
    long count(Create create);

    /**
     * 新增数据
     *
     * @param create 实例对象
     * @return 影响行数
     */
    int insert(Create create);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Create> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Create> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Create> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Create> entities);

    /**
     * 修改数据
     *
     * @param create 实例对象
     * @return 影响行数
     */
    int update(Create create);

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 影响行数
     */
    int deleteById(Integer cid);

}

