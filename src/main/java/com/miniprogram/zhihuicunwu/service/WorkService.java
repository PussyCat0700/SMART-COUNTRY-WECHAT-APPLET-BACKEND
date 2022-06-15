package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Work;
import java.util.List;

/**
 * (Work)表服务接口
 *
 * @author makejava
 * @since 2022-06-05 17:03:30
 */
public interface WorkService {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    List<Work> queryById(Integer did);

    /**
     * 通过任意字段查询数据列表
     *
     * @param work 实例对象
     * @return 实例对象列表
     */
    List<Work> queryAllByAny(Work work);
    
    /**
     * 新增数据
     *
     * @param work 实例对象
     * @return 实例对象
     */
    Work insert(Work work);

    /**
     * 修改数据
     *
     * @param work 实例对象
     * @return 实例对象
     */
    List<Work> update(Work work);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    boolean deleteById(Integer did);

}
