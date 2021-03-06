package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Department;

import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface DepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Department queryById(Integer did);

    List<Department> queryByCid(Integer cid);

    Department queryByDcode(String dcode);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    boolean deleteById(Integer did);

}
