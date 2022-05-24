package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairsarrival;

/**
 * (Deptgovaffairsarrival)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 17:56:21
 */
public interface DeptgovaffairsarrivalService {

    /**
     * 通过ID查询单条数据
     *
     * @param gaaid 主键
     * @return 实例对象
     */
    Deptgovaffairsarrival queryById(Integer gaaid);

    /**
     * 新增数据
     *
     * @param deptgovaffairsarrival 实例对象
     * @return 实例对象
     */
    Deptgovaffairsarrival insert(Deptgovaffairsarrival deptgovaffairsarrival);

    /**
     * 修改数据
     *
     * @param deptgovaffairsarrival 实例对象
     * @return 实例对象
     */
    Deptgovaffairsarrival update(Deptgovaffairsarrival deptgovaffairsarrival);

    /**
     * 通过主键删除数据
     *
     * @param gaaid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gaaid);

}
