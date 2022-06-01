package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Publication;

/**
 * (Publication)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface PublicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Publication queryById(Integer pid);

    /**
     * 新增数据
     *
     * @param publication 实例对象
     * @return 实例对象
     */
    Publication insert(Publication publication);

    /**
     * 修改数据
     *
     * @param publication 实例对象
     * @return 实例对象
     */
    Publication update(Publication publication);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pid);

}
