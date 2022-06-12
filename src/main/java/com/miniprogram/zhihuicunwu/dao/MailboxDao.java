package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Mailbox;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Mailbox)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 14:25:59
 */
public interface MailboxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param mid 主键
     * @return 实例对象
     */
    Mailbox queryById(Integer mid);

    List<Mailbox> queryByCid(Integer cid);

    /**
     * 查询指定行数据
     *
     * @param mailbox 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Mailbox> queryAllByLimit(Mailbox mailbox, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mailbox 查询条件
     * @return 总行数
     */
    long count(Mailbox mailbox);

    /**
     * 新增数据
     *
     * @param mailbox 实例对象
     * @return 影响行数
     */
    int insert(Mailbox mailbox);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Mailbox> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Mailbox> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Mailbox> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Mailbox> entities);

    /**
     * 修改数据
     *
     * @param mailbox 实例对象
     * @return 影响行数
     */
    int update(Mailbox mailbox);

    /**
     * 通过主键删除数据
     *
     * @param mid 主键
     * @return 影响行数
     */
    int deleteById(Integer mid);

}

