package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Mailbox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Mailbox)表服务接口
 *
 * @author makejava
 * @since 2022-06-05 14:26:57
 */
public interface MailboxService {

    /**
     * 通过ID查询单条数据
     *
     * @param mid 主键
     * @return 实例对象
     */
    Mailbox queryById(Integer mid);

    List<Mailbox> queryByCid(Integer cid);

    /**
     * 分页查询
     *
     * @param mailbox 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Mailbox> queryByPage(Mailbox mailbox, PageRequest pageRequest);

    List<Mailbox> queryAllByAny(Mailbox mailbox);

    /**
     * 新增数据
     *
     * @param mailbox 实例对象
     * @return 实例对象
     */
    Mailbox insert(Mailbox mailbox);

    /**
     * 修改数据
     *
     * @param mailbox 实例对象
     * @return 实例对象
     */
    Mailbox update(Mailbox mailbox);

    /**
     * 通过主键删除数据
     *
     * @param mid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer mid);

}
