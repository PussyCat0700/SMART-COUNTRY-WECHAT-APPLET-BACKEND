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
 * @since 2022-06-01 14:39:27
 */
@Service("createService")
public class CreateServiceImpl implements CreateService {
    @Resource
    private CreateDao createDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    @Override
    public Create queryById(Integer cid) {
        return this.createDao.queryById(cid);
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
     * @param cid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cid) {
        return this.createDao.deleteById(cid) > 0;
    }
}
