package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairs;
import java.util.List;

/**
 * (Deptgovaffairs)表服务接口
 *
 * @author makejava
 * @since 2022-06-05 15:53:28
 */
public interface DeptgovaffairsService {

    /**
     * 通过ID查询单条数据
     *
     * @param deptgovid 主键
     * @return 实例对象
     */
    Deptgovaffairs queryById(Integer deptgovid);

    /**
     * 通过任意字段查询数据列表
     *
     * @param deptgovaffairs 实例对象
     * @return 实例对象列表
     */
    List<Deptgovaffairs> queryAllByAny(Deptgovaffairs deptgovaffairs);
    
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
     * @param deptgovid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer deptgovid);

}
