package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Mailboximg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Mailboximg)表服务接口
 *
 * @author makejava
 * @since 2022-06-06 16:09:23
 */
public interface MailboximgService {

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    Mailboximg queryById(Integer imgId);

    /**
     * 分页查询
     *
     * @param mailboximg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Mailboximg> queryByPage(Mailboximg mailboximg, PageRequest pageRequest);

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
     * @param imgId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer imgId);

}
