package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairs;
import java.util.List;

/**
 * (Usergovaffairs)表服务接口
 *
 * @author makejava
 * @since 2022-06-05 15:49:47
 */
public interface UsergovaffairsService {

    /**
     * 通过ID查询单条数据
     *
     * @param usergaid 主键
     * @return 实例对象
     */
    Usergovaffairs queryById(Integer usergaid);

    /**
     * 通过任意字段查询数据列表
     *
     * @param usergovaffairs 实例对象
     * @return 实例对象列表
     */
    List<Usergovaffairs> queryAllByAny(Usergovaffairs usergovaffairs);
    
    /**
     * 新增数据
     *
     * @param usergovaffairs 实例对象
     * @return 实例对象
     */
    Usergovaffairs insert(Usergovaffairs usergovaffairs);

    /**
     * 修改数据
     *
     * @param usergovaffairs 实例对象
     * @return 实例对象
     */
    Usergovaffairs update(Usergovaffairs usergovaffairs);

    /**
     * 通过主键删除数据
     *
     * @param usergaid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer usergaid);

}
