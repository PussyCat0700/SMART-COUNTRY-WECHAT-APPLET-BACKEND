package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Govaffairsspot;

/**
 * (Govaffairsspot)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 17:56:23
 */
public interface GovaffairsspotService {

    /**
     * 通过ID查询单条数据
     *
     * @param gasid 主键
     * @return 实例对象
     */
    Govaffairsspot queryById(Integer gasid);

    /**
     * 新增数据
     *
     * @param govaffairsspot 实例对象
     * @return 实例对象
     */
    Govaffairsspot insert(Govaffairsspot govaffairsspot);

    /**
     * 修改数据
     *
     * @param govaffairsspot 实例对象
     * @return 实例对象
     */
    Govaffairsspot update(Govaffairsspot govaffairsspot);

    /**
     * 通过主键删除数据
     *
     * @param gasid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gasid);

}
