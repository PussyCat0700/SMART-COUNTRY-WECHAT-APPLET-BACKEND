package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Mailbox;
import com.miniprogram.zhihuicunwu.dao.MailboxDao;
import com.miniprogram.zhihuicunwu.service.MailboxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Mailbox)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("mailboxService")
public class MailboxServiceImpl implements MailboxService {
    @Resource
    private MailboxDao mailboxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mid 主键
     * @return 实例对象
     */
    @Override
    public Mailbox queryById(Integer mid) {
        return this.mailboxDao.queryById(mid);
    }

    /**
     * 新增数据
     *
     * @param mailbox 实例对象
     * @return 实例对象
     */
    @Override
    public Mailbox insert(Mailbox mailbox) {
        this.mailboxDao.insert(mailbox);
        return mailbox;
    }

    /**
     * 修改数据
     *
     * @param mailbox 实例对象
     * @return 实例对象
     */
    @Override
    public Mailbox update(Mailbox mailbox) {
        this.mailboxDao.update(mailbox);
        return this.queryById(mailbox.getMid());
    }

    /**
     * 通过主键删除数据
     *
     * @param mid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer mid) {
        return this.mailboxDao.deleteById(mid) > 0;
    }
}
