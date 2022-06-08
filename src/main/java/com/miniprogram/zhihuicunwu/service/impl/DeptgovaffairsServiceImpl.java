package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairs;
import com.miniprogram.zhihuicunwu.dao.DeptgovaffairsDao;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Deptgovaffairs)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 22:09:53
 */
@Service("deptgovaffairsService")
public class DeptgovaffairsServiceImpl implements DeptgovaffairsService {
    @Resource
    private DeptgovaffairsDao deptgovaffairsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deptgovid 主键
     * @return 实例对象
     */
    @Override
    public Deptgovaffairs queryById(Integer deptgovid) {
        return this.deptgovaffairsDao.queryById(deptgovid);
    }

    @Override
    //通过did获取数据
    public List<Deptgovaffairs> queryByDid(Integer did) { return this.deptgovaffairsDao.queryByDid(did); }
    
    /**
     * 通过任意字段查询数据列表
     *
     * @param deptgovaffairs 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<Deptgovaffairs> queryAllByAny(Deptgovaffairs deptgovaffairs){
        return this.deptgovaffairsDao.queryAllByAny(deptgovaffairs);
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
        return this.queryById(deptgovaffairs.getDeptgovid());
    }

    /**
     * 通过主键删除数据
     *
     * @param deptgovid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer deptgovid) {
        return this.deptgovaffairsDao.deleteById(deptgovid) > 0;
    }
}
