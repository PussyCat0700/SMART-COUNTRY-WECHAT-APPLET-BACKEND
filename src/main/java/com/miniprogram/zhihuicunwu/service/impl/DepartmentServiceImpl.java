package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Department;
import com.miniprogram.zhihuicunwu.dao.DepartmentDao;
import com.miniprogram.zhihuicunwu.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer did) {
        return this.departmentDao.queryById(did);
    }

    @Override
    public List<Department> queryByCid(Integer cid) { return this.departmentDao.queryByCid(cid); }

    @Override
    public Department queryByDcode(String dcode) { return this.departmentDao.queryByDcode(dcode); }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentDao.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentDao.update(department);
        return this.queryById(department.getDid());
    }

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer did) {
        return this.departmentDao.deleteById(did) > 0;
    }
}
