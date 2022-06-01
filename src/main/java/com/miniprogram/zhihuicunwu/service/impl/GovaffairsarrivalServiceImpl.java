package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Govaffairsarrival;
import com.miniprogram.zhihuicunwu.dao.GovaffairsarrivalDao;
import com.miniprogram.zhihuicunwu.service.GovaffairsarrivalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Govaffairsarrival)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("govaffairsarrivalService")
public class GovaffairsarrivalServiceImpl implements GovaffairsarrivalService {
    @Resource
    private GovaffairsarrivalDao govaffairsarrivalDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gaaid 主键
     * @return 实例对象
     */
    @Override
    public Govaffairsarrival queryById(Integer gaaid) {
        return this.govaffairsarrivalDao.queryById(gaaid);
    }

    /**
     * 新增数据
     *
     * @param govaffairsarrival 实例对象
     * @return 实例对象
     */
    @Override
    public Govaffairsarrival insert(Govaffairsarrival govaffairsarrival) {
        this.govaffairsarrivalDao.insert(govaffairsarrival);
        return govaffairsarrival;
    }

    /**
     * 修改数据
     *
     * @param govaffairsarrival 实例对象
     * @return 实例对象
     */
    @Override
    public Govaffairsarrival update(Govaffairsarrival govaffairsarrival) {
        this.govaffairsarrivalDao.update(govaffairsarrival);
        return this.queryById(govaffairsarrival.getGaaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gaaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gaaid) {
        return this.govaffairsarrivalDao.deleteById(gaaid) > 0;
    }
}
