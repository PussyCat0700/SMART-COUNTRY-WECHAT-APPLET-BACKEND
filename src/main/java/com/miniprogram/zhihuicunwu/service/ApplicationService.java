package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Application;
import java.util.List;

/**
 * (Application)表服务接口
 *
 * @author makejava
 * @since 2022-06-06 22:55:46
 */
public interface ApplicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param applicationId 主键
     * @return 实例对象
     */
    Application queryById(Integer applicationId);

    /**
     * 通过任意字段查询数据列表
     *
     * @param application 实例对象
     * @return 实例对象列表
     */
    List<Application> queryAllByAny(Application application);
    
    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    Application insert(Application application);

    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    Application update(Application application);

    /**
     * 通过主键删除数据
     *
     * @param applicationId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer applicationId);

}
