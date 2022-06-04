package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Countrydepartment;
import com.miniprogram.zhihuicunwu.dao.CountrydepartmentDao;
import com.miniprogram.zhihuicunwu.service.CountrydepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Countrydepartment)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("countrydepartmentService")
public class CountrydepartmentServiceImpl implements CountrydepartmentService {
    @Resource
    private CountrydepartmentDao countrydepartmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    @Override
    public Countrydepartment queryById(Integer did) {
        return this.countrydepartmentDao.queryById(did);
    }

    @Override
    public List<Countrydepartment> queryByCid(int cid)
    {
        return this.countrydepartmentDao.queryByCid(cid);
    }

    /**
     * 新增数据
     *
     * @param countrydepartment 实例对象
     * @return 实例对象
     */
    @Override
    public Countrydepartment insert(Countrydepartment countrydepartment) {
        this.countrydepartmentDao.insert(countrydepartment);
        return countrydepartment;
    }

    /**
     * 修改数据
     *
     * @param countrydepartment 实例对象
     * @return 实例对象
     */
    @Override
    public Countrydepartment update(Countrydepartment countrydepartment) {
        this.countrydepartmentDao.update(countrydepartment);
        return this.queryById(countrydepartment.getDid());
    }

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer did) {
        return this.countrydepartmentDao.deleteById(did) > 0;
    }
}
