package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Resident;

/**
 * (Resident)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 17:56:24
 */
public interface ResidentService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Resident queryById(Integer uid);

    /**
     * 新增数据
     *
     * @param resident 实例对象
     * @return 实例对象
     */
    Resident insert(Resident resident);

    /**
     * 修改数据
     *
     * @param resident 实例对象
     * @return 实例对象
     */
    Resident update(Resident resident);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

}
