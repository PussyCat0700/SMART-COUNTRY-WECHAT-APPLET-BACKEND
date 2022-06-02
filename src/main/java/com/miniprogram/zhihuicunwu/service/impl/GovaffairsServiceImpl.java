package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.dao.GovaffairsDao;
import com.miniprogram.zhihuicunwu.entity.Govaffairs;
import com.miniprogram.zhihuicunwu.service.GovaffairsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Govaffairs)表服务实现类
 *
 * @author makejava
 * @since 2022-06-02 22:26:11
 */
@Service("govaffairsService")
public class GovaffairsServiceImpl implements GovaffairsService {
    @Resource
    private GovaffairsDao govaffairsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gaid 主键
     * @return 实例对象
     */
    @Override
    public Govaffairs queryById(Integer gaid) {
        return this.govaffairsDao.queryById(gaid);
    }

    /**
     * 新增数据
     *
     * @param govaffairs 实例对象
     * @return 实例对象
     */
    @Override
    public Govaffairs insert(Govaffairs govaffairs) {
        this.govaffairsDao.insert(govaffairs);
        return govaffairs;
    }

    /**
     * 修改数据
     *
     * @param govaffairs 实例对象
     * @return 实例对象
     */
    @Override
    public Govaffairs update(Govaffairs govaffairs) {
        this.govaffairsDao.update(govaffairs);
        return this.queryById(govaffairs.getGaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gaid) {
        return this.govaffairsDao.deleteById(gaid) > 0;
    }
}
