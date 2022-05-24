package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairsarrival;
import com.miniprogram.zhihuicunwu.dao.DeptgovaffairsarrivalDao;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsarrivalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Deptgovaffairsarrival)表服务实现类
 *
 * @author makejava
 * @since 2022-05-24 17:56:21
 */
@Service("deptgovaffairsarrivalService")
public class DeptgovaffairsarrivalServiceImpl implements DeptgovaffairsarrivalService {
    @Resource
    private DeptgovaffairsarrivalDao deptgovaffairsarrivalDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gaaid 主键
     * @return 实例对象
     */
    @Override
    public Deptgovaffairsarrival queryById(Integer gaaid) {
        return this.deptgovaffairsarrivalDao.queryById(gaaid);
    }

    /**
     * 新增数据
     *
     * @param deptgovaffairsarrival 实例对象
     * @return 实例对象
     */
    @Override
    public Deptgovaffairsarrival insert(Deptgovaffairsarrival deptgovaffairsarrival) {
        this.deptgovaffairsarrivalDao.insert(deptgovaffairsarrival);
        return deptgovaffairsarrival;
    }

    /**
     * 修改数据
     *
     * @param deptgovaffairsarrival 实例对象
     * @return 实例对象
     */
    @Override
    public Deptgovaffairsarrival update(Deptgovaffairsarrival deptgovaffairsarrival) {
        this.deptgovaffairsarrivalDao.update(deptgovaffairsarrival);
        return this.queryById(deptgovaffairsarrival.getGaaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gaaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gaaid) {
        return this.deptgovaffairsarrivalDao.deleteById(gaaid) > 0;
    }
}
