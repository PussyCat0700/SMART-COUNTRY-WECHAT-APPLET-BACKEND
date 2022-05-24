package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Create;
import com.miniprogram.zhihuicunwu.dao.CreateDao;
import com.miniprogram.zhihuicunwu.service.CreateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Create)表服务实现类
 *
 * @author makejava
 * @since 2022-05-24 17:56:21
 */
@Service("createService")
public class CreateServiceImpl implements CreateService {
    @Resource
    private CreateDao createDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public Create queryById(Integer uid) {
        return this.createDao.queryById(uid);
    }

    /**
     * 新增数据
     *
     * @param create 实例对象
     * @return 实例对象
     */
    @Override
    public Create insert(Create create) {
        this.createDao.insert(create);
        return create;
    }

    /**
     * 修改数据
     *
     * @param create 实例对象
     * @return 实例对象
     */
    @Override
    public Create update(Create create) {
        this.createDao.update(create);
        return this.queryById(create.getUid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uid) {
        return this.createDao.deleteById(uid) > 0;
    }
}
