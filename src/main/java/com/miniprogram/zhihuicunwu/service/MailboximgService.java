package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Mailboximg;

/**
 * (Mailboximg)表服务接口
 *
 * @author makejava
 * @since 2022-06-03 11:26:26
 */
public interface MailboximgService {

    /**
     * 通过ID查询单条数据
     *
     * @param mailboxid 主键
     * @return 实例对象
     */
    Mailboximg queryById(Integer mailboxid);

    /**
     * 新增数据
     *
     * @param mailboximg 实例对象
     * @return 实例对象
     */
    Mailboximg insert(Mailboximg mailboximg);

    /**
     * 修改数据
     *
     * @param mailboximg 实例对象
     * @return 实例对象
     */
    Mailboximg update(Mailboximg mailboximg);

    /**
     * 通过主键删除数据
     *
     * @param mailboxid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer mailboxid);

}
