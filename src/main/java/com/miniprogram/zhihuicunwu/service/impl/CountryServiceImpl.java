package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Country;
import com.miniprogram.zhihuicunwu.dao.CountryDao;
import com.miniprogram.zhihuicunwu.service.CountryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Country)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("countryService")
public class CountryServiceImpl implements CountryService {
    @Resource
    private CountryDao countryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    @Override
    public Country queryById(Integer cid) {
        return this.countryDao.queryById(cid);
    }

    /**
     * 新增数据
     *
     * @param country 实例对象
     * @return 实例对象
     */
    @Override
    public Country insert(Country country) {
        this.countryDao.insert(country);
        return country;
    }

    /**
     * 修改数据
     *
     * @param country 实例对象
     * @return 实例对象
     */
    @Override
    public Country update(Country country) {
        this.countryDao.update(country);
        return this.queryById(country.getCid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cid) {
        return this.countryDao.deleteById(cid) > 0;
    }
}
