package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Application;
import com.miniprogram.zhihuicunwu.dao.ApplicationDao;
import com.miniprogram.zhihuicunwu.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Application)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 22:55:46
 */
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {
    @Resource
    private ApplicationDao applicationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param applicationId 主键
     * @return 实例对象
     */
    @Override
    public Application queryById(Integer applicationId) {
        return this.applicationDao.queryById(applicationId);
    }
    
    /**
     * 通过任意字段查询数据列表
     *
     * @param application 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<Application> queryAllByAny(Application application){
        return this.applicationDao.queryAllByAny(application);
    }

    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    @Override
    public Application insert(Application application) {
        this.applicationDao.insert(application);
        return application;
    }

    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    @Override
    public Application update(Application application) {
        this.applicationDao.update(application);
        return this.queryById(application.getApplicationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param applicationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer applicationId) {
        return this.applicationDao.deleteById(applicationId) > 0;
    }
}
