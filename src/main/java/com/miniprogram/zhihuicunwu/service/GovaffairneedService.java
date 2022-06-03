package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Govaffairneed;

/**
 * (Govaffairneed)表服务接口
 *
 * @author makejava
 * @since 2022-06-03 11:40:55
 */
public interface GovaffairneedService {

    /**
     * 通过ID查询单条数据
     *
     * @param needgovaffairid 主键
     * @return 实例对象
     */
    Govaffairneed queryById(Integer needgovaffairid);

    /**
     * 新增数据
     *
     * @param govaffairneed 实例对象
     * @return 实例对象
     */
    Govaffairneed insert(Govaffairneed govaffairneed);

    /**
     * 修改数据
     *
     * @param govaffairneed 实例对象
     * @return 实例对象
     */
    Govaffairneed update(Govaffairneed govaffairneed);

    /**
     * 通过主键删除数据
     *
     * @param needgovaffairid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer needgovaffairid);

}
