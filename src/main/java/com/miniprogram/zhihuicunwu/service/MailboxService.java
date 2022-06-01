package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Mailbox;

/**
 * (Mailbox)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface MailboxService {

    /**
     * 通过ID查询单条数据
     *
     * @param mid 主键
     * @return 实例对象
     */
    Mailbox queryById(Integer mid);

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
