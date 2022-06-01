package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Publish;
import com.miniprogram.zhihuicunwu.dao.PublishDao;
import com.miniprogram.zhihuicunwu.service.PublishService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Publish)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("publishService")
public class PublishServiceImpl implements PublishService {
    @Resource
    private PublishDao publishDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Publish queryById(Integer pid) {
        return this.publishDao.queryById(pid);
    }

    /**
     * 新增数据
     *
     * @param publish 实例对象
     * @return 实例对象
     */
    @Override
    public Publish insert(Publish publish) {
        this.publishDao.insert(publish);
        return publish;
    }

    /**
     * 修改数据
     *
     * @param publish 实例对象
     * @return 实例对象
     */
    @Override
    public Publish update(Publish publish) {
        this.publishDao.update(publish);
        return this.queryById(publish.getPid());
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pid) {
        return this.publishDao.deleteById(pid) > 0;
    }
}
