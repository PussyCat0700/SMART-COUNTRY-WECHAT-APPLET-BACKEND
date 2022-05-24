package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Create;

/**
 * (Create)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 17:56:21
 */
public interface CreateService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Create queryById(Integer uid);

    /**
     * 新增数据
     *
     * @param create 实例对象
     * @return 实例对象
     */
    Create insert(Create create);

    /**
     * 修改数据
     *
     * @param create 实例对象
     * @return 实例对象
     */
    Create update(Create create);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

}
