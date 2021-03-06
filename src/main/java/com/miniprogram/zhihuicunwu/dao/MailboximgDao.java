package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Mailboximg;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Mailboximg)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-06 16:09:18
 */
public interface MailboximgDao {

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    Mailboximg queryById(Integer imgId);

    List<Mailboximg> queryByMid(Integer mid);

    /**
     * 查询指定行数据
     *
     * @param mailboximg 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Mailboximg> queryAllByLimit(Mailboximg mailboximg, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mailboximg 查询条件
     * @return 总行数
     */
    long count(Mailboximg mailboximg);

    /**
     * 新增数据
     *
     * @param mailboximg 实例对象
     * @return 影响行数
     */
    int insert(Mailboximg mailboximg);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Mailboximg> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Mailboximg> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Mailboximg> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Mailboximg> entities);

    /**
     * 修改数据
     *
     * @param mailboximg 实例对象
     * @return 影响行数
     */
    int update(Mailboximg mailboximg);

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 影响行数
     */
    int deleteById(Integer imgId);

}

