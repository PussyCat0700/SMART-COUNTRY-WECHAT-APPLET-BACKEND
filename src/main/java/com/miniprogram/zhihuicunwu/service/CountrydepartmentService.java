package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Countrydepartment;

/**
 * (Countrydepartment)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 17:56:20
 */
public interface CountrydepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Countrydepartment queryById(Integer did);

    /**
     * 新增数据
     *
     * @param countrydepartment 实例对象
     * @return 实例对象
     */
    Countrydepartment insert(Countrydepartment countrydepartment);

    /**
     * 修改数据
     *
     * @param countrydepartment 实例对象
     * @return 实例对象
     */
    Countrydepartment update(Countrydepartment countrydepartment);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    boolean deleteById(Integer did);

}
