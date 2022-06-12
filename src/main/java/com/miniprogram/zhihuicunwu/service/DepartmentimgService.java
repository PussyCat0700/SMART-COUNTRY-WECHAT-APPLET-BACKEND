package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Departmentimg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Departmentimg)表服务接口
 *
 * @author makejava
 * @since 2022-06-07 13:22:44
 */
public interface DepartmentimgService {

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    Departmentimg queryById(Integer imgId);

    Departmentimg queryByDid(Integer did);

    /**
     * 分页查询
     *
     * @param departmentimg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Departmentimg> queryByPage(Departmentimg departmentimg, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param departmentimg 实例对象
     * @return 实例对象
     */
    Departmentimg insert(Departmentimg departmentimg);

    /**
     * 修改数据
     *
     * @param departmentimg 实例对象
     * @return 实例对象
     */
    Departmentimg update(Departmentimg departmentimg);

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer imgId);

}
