package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Application;
import com.miniprogram.zhihuicunwu.dao.ApplicationDao;
import com.miniprogram.zhihuicunwu.service.ApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Application)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 11:42:27
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
     * 分页查询
     *
     * @param application 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Application> queryByPage(Application application, PageRequest pageRequest) {
        long total = this.applicationDao.count(application);
        return new PageImpl<>(this.applicationDao.queryAllByLimit(application, pageRequest), pageRequest, total);
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
