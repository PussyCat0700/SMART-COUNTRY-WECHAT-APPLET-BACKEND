package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Application)表服务接口
 *
 * @author makejava
 * @since 2022-06-06 11:42:27
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
     * 分页查询
     *
     * @param application 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Application> queryByPage(Application application, PageRequest pageRequest);

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
