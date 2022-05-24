package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Govaffairsarrival;

/**
 * (Govaffairsarrival)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 17:56:22
 */
public interface GovaffairsarrivalService {

    /**
     * 通过ID查询单条数据
     *
     * @param gaaid 主键
     * @return 实例对象
     */
    Govaffairsarrival queryById(Integer gaaid);

    /**
     * 新增数据
     *
     * @param govaffairsarrival 实例对象
     * @return 实例对象
     */
    Govaffairsarrival insert(Govaffairsarrival govaffairsarrival);

    /**
     * 修改数据
     *
     * @param govaffairsarrival 实例对象
     * @return 实例对象
     */
    Govaffairsarrival update(Govaffairsarrival govaffairsarrival);

    /**
     * 通过主键删除数据
     *
     * @param gaaid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gaaid);

}
