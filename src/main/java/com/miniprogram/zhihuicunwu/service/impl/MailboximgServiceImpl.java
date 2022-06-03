package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Mailboximg;
import com.miniprogram.zhihuicunwu.dao.MailboximgDao;
import com.miniprogram.zhihuicunwu.service.MailboximgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Mailboximg)表服务实现类
 *
 * @author makejava
 * @since 2022-06-03 11:26:26
 */
@Service("mailboximgService")
public class MailboximgServiceImpl implements MailboximgService {
    @Resource
    private MailboximgDao mailboximgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mailboxid 主键
     * @return 实例对象
     */
    @Override
    public Mailboximg queryById(Integer mailboxid) {
        return this.mailboximgDao.queryById(mailboxid);
    }

    /**
     * 新增数据
     *
     * @param mailboximg 实例对象
     * @return 实例对象
     */
    @Override
    public Mailboximg insert(Mailboximg mailboximg) {
        this.mailboximgDao.insert(mailboximg);
        return mailboximg;
    }

    /**
     * 修改数据
     *
     * @param mailboximg 实例对象
     * @return 实例对象
     */
    @Override
    public Mailboximg update(Mailboximg mailboximg) {
        this.mailboximgDao.update(mailboximg);
        return this.queryById(mailboximg.getMailboxid());
    }

    /**
     * 通过主键删除数据
     *
     * @param mailboxid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer mailboxid) {
        return this.mailboximgDao.deleteById(mailboxid) > 0;
    }
}
