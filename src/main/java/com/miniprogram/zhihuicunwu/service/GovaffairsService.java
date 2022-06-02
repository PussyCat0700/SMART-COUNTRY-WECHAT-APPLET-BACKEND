package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Govaffairs;

/**
 * (Govaffairs)表服务接口
 *
 * @author makejava
 * @since 2022-06-02 22:26:11
 */
public interface GovaffairsService {

    /**
     * 通过ID查询单条数据
     *
     * @param gaid 主键
     * @return 实例对象
     */
    Govaffairs queryById(Integer gaid);

    /**
     * 新增数据
     *
     * @param govaffairs 实例对象
     * @return 实例对象
     */
    Govaffairs insert(Govaffairs govaffairs);

    /**
     * 修改数据
     *
     * @param govaffairs 实例对象
     * @return 实例对象
     */
    Govaffairs update(Govaffairs govaffairs);

    /**
     * 通过主键删除数据
     *
     * @param gaid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gaid);

}
