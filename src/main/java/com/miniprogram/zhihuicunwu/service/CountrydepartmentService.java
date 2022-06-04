package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Countrydepartment;

import java.util.List;

/**
 * (Countrydepartment)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface CountrydepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Countrydepartment queryById(Integer did);

    //查询某村下所有的部门信息
    List<Countrydepartment> queryByCid(int cid);

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
