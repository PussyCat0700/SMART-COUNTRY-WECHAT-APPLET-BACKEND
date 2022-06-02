package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairs;
import com.miniprogram.zhihuicunwu.dao.DeptgovaffairsDao;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Deptgovaffairs)表服务实现类
 *
 * @author makejava
 * @since 2022-06-02 22:26:09
 */
@Service("deptgovaffairsService")
public class DeptgovaffairsServiceImpl implements DeptgovaffairsService {
    @Resource
    private DeptgovaffairsDao deptgovaffairsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gaid 主键
     * @return 实例对象
     */
    @Override
    public Deptgovaffairs queryById(Integer gaid) {
        return this.deptgovaffairsDao.queryById(gaid);
    }

    /**
     * 新增数据
     *
     * @param deptgovaffairs 实例对象
     * @return 实例对象
     */
    @Override
    public Deptgovaffairs insert(Deptgovaffairs deptgovaffairs) {
        this.deptgovaffairsDao.insert(deptgovaffairs);
        return deptgovaffairs;
    }

    /**
     * 修改数据
     *
     * @param deptgovaffairs 实例对象
     * @return 实例对象
     */
    @Override
    public Deptgovaffairs update(Deptgovaffairs deptgovaffairs) {
        this.deptgovaffairsDao.update(deptgovaffairs);
        return this.queryById(deptgovaffairs.getGaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gaid) {
        return this.deptgovaffairsDao.deleteById(gaid) > 0;
    }
}
