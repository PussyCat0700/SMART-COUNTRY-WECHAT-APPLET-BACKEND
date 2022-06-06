package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Govaffairneed;
import com.miniprogram.zhihuicunwu.dao.GovaffairneedDao;
import com.miniprogram.zhihuicunwu.service.GovaffairneedService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Govaffairneed)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 17:19:04
 */
@Service("govaffairneedService")
public class GovaffairneedServiceImpl implements GovaffairneedService {
    @Resource
    private GovaffairneedDao govaffairneedDao;

    /**
     * 通过ID查询单条数据
     *
     * @param needId 主键
     * @return 实例对象
     */
    @Override
    public Govaffairneed queryById(Integer needId) {
        return this.govaffairneedDao.queryById(needId);
    }

    /**
     * 分页查询
     *
     * @param govaffairneed 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Govaffairneed> queryByPage(Govaffairneed govaffairneed, PageRequest pageRequest) {
        long total = this.govaffairneedDao.count(govaffairneed);
        return new PageImpl<>(this.govaffairneedDao.queryAllByLimit(govaffairneed, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param govaffairneed 实例对象
     * @return 实例对象
     */
    @Override
    public Govaffairneed insert(Govaffairneed govaffairneed) {
        this.govaffairneedDao.insert(govaffairneed);
        return govaffairneed;
    }

    /**
     * 修改数据
     *
     * @param govaffairneed 实例对象
     * @return 实例对象
     */
    @Override
    public Govaffairneed update(Govaffairneed govaffairneed) {
        this.govaffairneedDao.update(govaffairneed);
        return this.queryById(govaffairneed.getNeedId());
    }

    /**
     * 通过主键删除数据
     *
     * @param needId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer needId) {
        return this.govaffairneedDao.deleteById(needId) > 0;
    }
}
