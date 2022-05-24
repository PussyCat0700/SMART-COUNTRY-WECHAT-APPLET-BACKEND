package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairsspot;
import com.miniprogram.zhihuicunwu.dao.DeptgovaffairsspotDao;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsspotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Deptgovaffairsspot)表服务实现类
 *
 * @author makejava
 * @since 2022-05-24 17:56:22
 */
@Service("deptgovaffairsspotService")
public class DeptgovaffairsspotServiceImpl implements DeptgovaffairsspotService {
    @Resource
    private DeptgovaffairsspotDao deptgovaffairsspotDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gasid 主键
     * @return 实例对象
     */
    @Override
    public Deptgovaffairsspot queryById(Integer gasid) {
        return this.deptgovaffairsspotDao.queryById(gasid);
    }

    /**
     * 新增数据
     *
     * @param deptgovaffairsspot 实例对象
     * @return 实例对象
     */
    @Override
    public Deptgovaffairsspot insert(Deptgovaffairsspot deptgovaffairsspot) {
        this.deptgovaffairsspotDao.insert(deptgovaffairsspot);
        return deptgovaffairsspot;
    }

    /**
     * 修改数据
     *
     * @param deptgovaffairsspot 实例对象
     * @return 实例对象
     */
    @Override
    public Deptgovaffairsspot update(Deptgovaffairsspot deptgovaffairsspot) {
        this.deptgovaffairsspotDao.update(deptgovaffairsspot);
        return this.queryById(deptgovaffairsspot.getGasid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gasid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gasid) {
        return this.deptgovaffairsspotDao.deleteById(gasid) > 0;
    }
}
