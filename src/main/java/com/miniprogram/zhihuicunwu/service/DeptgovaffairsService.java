package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairs;

/**
 * (Deptgovaffairs)表服务接口
 *
 * @author makejava
 * @since 2022-06-02 22:26:09
 */
public interface DeptgovaffairsService {

    /**
     * 通过ID查询单条数据
     *
     * @param gaid 主键
     * @return 实例对象
     */
    Deptgovaffairs queryById(Integer gaid);

    /**
     * 新增数据
     *
     * @param deptgovaffairs 实例对象
     * @return 实例对象
     */
    Deptgovaffairs insert(Deptgovaffairs deptgovaffairs);

    /**
     * 修改数据
     *
     * @param deptgovaffairs 实例对象
     * @return 实例对象
     */
    Deptgovaffairs update(Deptgovaffairs deptgovaffairs);

    /**
     * 通过主键删除数据
     *
     * @param gaid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gaid);

}
