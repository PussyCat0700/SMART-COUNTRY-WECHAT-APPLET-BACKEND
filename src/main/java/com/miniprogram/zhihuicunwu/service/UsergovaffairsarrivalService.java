package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairsarrival;

/**
 * (Usergovaffairsarrival)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface UsergovaffairsarrivalService {

    /**
     * 通过ID查询单条数据
     *
     * @param gaaid 主键
     * @return 实例对象
     */
    Usergovaffairsarrival queryById(Integer gaaid);

    /**
     * 新增数据
     *
     * @param usergovaffairsarrival 实例对象
     * @return 实例对象
     */
    Usergovaffairsarrival insert(Usergovaffairsarrival usergovaffairsarrival);

    /**
     * 修改数据
     *
     * @param usergovaffairsarrival 实例对象
     * @return 实例对象
     */
    Usergovaffairsarrival update(Usergovaffairsarrival usergovaffairsarrival);

    /**
     * 通过主键删除数据
     *
     * @param gaaid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gaaid);

}
