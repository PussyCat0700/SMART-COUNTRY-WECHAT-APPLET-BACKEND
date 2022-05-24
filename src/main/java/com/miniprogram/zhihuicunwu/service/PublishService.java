package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Publish;

/**
 * (Publish)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 17:56:24
 */
public interface PublishService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Publish queryById(Integer pid);

    /**
     * 新增数据
     *
     * @param publish 实例对象
     * @return 实例对象
     */
    Publish insert(Publish publish);

    /**
     * 修改数据
     *
     * @param publish 实例对象
     * @return 实例对象
     */
    Publish update(Publish publish);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pid);

}
