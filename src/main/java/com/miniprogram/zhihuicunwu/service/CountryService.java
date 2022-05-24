package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Country;

/**
 * (Country)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 17:56:20
 */
public interface CountryService {

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    Country queryById(Integer cid);

    /**
     * 新增数据
     *
     * @param country 实例对象
     * @return 实例对象
     */
    Country insert(Country country);

    /**
     * 修改数据
     *
     * @param country 实例对象
     * @return 实例对象
     */
    Country update(Country country);

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cid);

}
