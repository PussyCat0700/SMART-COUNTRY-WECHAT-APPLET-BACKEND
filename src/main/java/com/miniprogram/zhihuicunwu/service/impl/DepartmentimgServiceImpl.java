package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Departmentimg;
import com.miniprogram.zhihuicunwu.dao.DepartmentimgDao;
import com.miniprogram.zhihuicunwu.service.DepartmentimgService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Departmentimg)表服务实现类
 *
 * @author makejava
 * @since 2022-06-07 13:22:44
 */
@Service("departmentimgService")
public class DepartmentimgServiceImpl implements DepartmentimgService {
    @Resource
    private DepartmentimgDao departmentimgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    @Override
    public Departmentimg queryById(Integer imgId) {
        return this.departmentimgDao.queryById(imgId);
    }

    @Override
    public List<Departmentimg> queryByDid(Integer did) { return this.departmentimgDao.queryByDid(did); }

    /**
     * 分页查询
     *
     * @param departmentimg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Departmentimg> queryByPage(Departmentimg departmentimg, PageRequest pageRequest) {
        long total = this.departmentimgDao.count(departmentimg);
        return new PageImpl<>(this.departmentimgDao.queryAllByLimit(departmentimg, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param departmentimg 实例对象
     * @return 实例对象
     */
    @Override
    public Departmentimg insert(Departmentimg departmentimg) {
        this.departmentimgDao.insert(departmentimg);
        return departmentimg;
    }

    /**
     * 修改数据
     *
     * @param departmentimg 实例对象
     * @return 实例对象
     */
    @Override
    public Departmentimg update(Departmentimg departmentimg) {
        this.departmentimgDao.update(departmentimg);
        return this.queryById(departmentimg.getImgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer imgId) {
        return this.departmentimgDao.deleteById(imgId) > 0;
    }
}
