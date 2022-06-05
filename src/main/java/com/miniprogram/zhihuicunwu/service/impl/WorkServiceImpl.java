package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Work;
import com.miniprogram.zhihuicunwu.dao.WorkDao;
import com.miniprogram.zhihuicunwu.service.WorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Work)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 17:03:30
 */
@Service("workService")
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorkDao workDao;

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    @Override
    public Work queryById(Integer did) {
        return this.workDao.queryById(did);
    }
    
    /**
     * 通过任意字段查询数据列表
     *
     * @param work 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<Work> queryAllByAny(Work work){
        return this.workDao.queryAllByAny(work);
    }

    /**
     * 新增数据
     *
     * @param work 实例对象
     * @return 实例对象
     */
    @Override
    public Work insert(Work work) {
        this.workDao.insert(work);
        return work;
    }

    /**
     * 修改数据
     *
     * @param work 实例对象
     * @return 实例对象
     */
    @Override
    public Work update(Work work) {
        this.workDao.update(work);
        return this.queryById(work.getDid());
    }

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer did) {
        return this.workDao.deleteById(did) > 0;
    }
}
