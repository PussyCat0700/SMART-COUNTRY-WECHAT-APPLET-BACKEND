package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Mailboximg;
import com.miniprogram.zhihuicunwu.dao.MailboximgDao;
import com.miniprogram.zhihuicunwu.service.MailboximgService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Mailboximg)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 16:09:23
 */
@Service("mailboximgService")
public class MailboximgServiceImpl implements MailboximgService {
    @Resource
    private MailboximgDao mailboximgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    @Override
    public Mailboximg queryById(Integer imgId) {
        return this.mailboximgDao.queryById(imgId);
    }

    @Override
    public List<Mailboximg> queryByMid(Integer mid) { return this.mailboximgDao.queryByMid(mid); }

    /**
     * 分页查询
     *
     * @param mailboximg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Mailboximg> queryByPage(Mailboximg mailboximg, PageRequest pageRequest) {
        long total = this.mailboximgDao.count(mailboximg);
        return new PageImpl<>(this.mailboximgDao.queryAllByLimit(mailboximg, pageRequest), pageRequest, total);
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
        return this.queryById(mailboximg.getImgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer imgId) {
        return this.mailboximgDao.deleteById(imgId) > 0;
    }
}
