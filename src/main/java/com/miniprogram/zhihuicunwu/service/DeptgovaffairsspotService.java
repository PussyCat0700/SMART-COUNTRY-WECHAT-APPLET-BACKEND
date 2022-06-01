package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairsspot;

/**
 * (Deptgovaffairsspot)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface DeptgovaffairsspotService {

    /**
     * 通过ID查询单条数据
     *
     * @param gasid 主键
     * @return 实例对象
     */
    Deptgovaffairsspot queryById(Integer gasid);

    /**
     * 新增数据
     *
     * @param deptgovaffairsspot 实例对象
     * @return 实例对象
     */
    Deptgovaffairsspot insert(Deptgovaffairsspot deptgovaffairsspot);

    /**
     * 修改数据
     *
     * @param deptgovaffairsspot 实例对象
     * @return 实例对象
     */
    Deptgovaffairsspot update(Deptgovaffairsspot deptgovaffairsspot);

    /**
     * 通过主键删除数据
     *
     * @param gasid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gasid);

}
