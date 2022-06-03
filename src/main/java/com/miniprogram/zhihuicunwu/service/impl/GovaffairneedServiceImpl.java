package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Govaffairneed;
import com.miniprogram.zhihuicunwu.dao.GovaffairneedDao;
import com.miniprogram.zhihuicunwu.service.GovaffairneedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Govaffairneed)表服务实现类
 *
 * @author makejava
 * @since 2022-06-03 11:40:55
 */
@Service("govaffairneedService")
public class GovaffairneedServiceImpl implements GovaffairneedService {
    @Resource
    private GovaffairneedDao govaffairneedDao;

    /**
     * 通过ID查询单条数据
     *
     * @param needgovaffairid 主键
     * @return 实例对象
     */
    @Override
    public Govaffairneed queryById(Integer needgovaffairid) {
        return this.govaffairneedDao.queryById(needgovaffairid);
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
        return this.queryById(govaffairneed.getNeedgovaffairid());
    }

    /**
     * 通过主键删除数据
     *
     * @param needgovaffairid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer needgovaffairid) {
        return this.govaffairneedDao.deleteById(needgovaffairid) > 0;
    }
}
