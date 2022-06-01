package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Govaffairsspot;
import com.miniprogram.zhihuicunwu.dao.GovaffairsspotDao;
import com.miniprogram.zhihuicunwu.service.GovaffairsspotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Govaffairsspot)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("govaffairsspotService")
public class GovaffairsspotServiceImpl implements GovaffairsspotService {
    @Resource
    private GovaffairsspotDao govaffairsspotDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gasid 主键
     * @return 实例对象
     */
    @Override
    public Govaffairsspot queryById(Integer gasid) {
        return this.govaffairsspotDao.queryById(gasid);
    }

    /**
     * 新增数据
     *
     * @param govaffairsspot 实例对象
     * @return 实例对象
     */
    @Override
    public Govaffairsspot insert(Govaffairsspot govaffairsspot) {
        this.govaffairsspotDao.insert(govaffairsspot);
        return govaffairsspot;
    }

    /**
     * 修改数据
     *
     * @param govaffairsspot 实例对象
     * @return 实例对象
     */
    @Override
    public Govaffairsspot update(Govaffairsspot govaffairsspot) {
        this.govaffairsspotDao.update(govaffairsspot);
        return this.queryById(govaffairsspot.getGasid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gasid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gasid) {
        return this.govaffairsspotDao.deleteById(gasid) > 0;
    }
}
