package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairsspot;
import com.miniprogram.zhihuicunwu.dao.UsergovaffairsspotDao;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsspotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Usergovaffairsspot)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("usergovaffairsspotService")
public class UsergovaffairsspotServiceImpl implements UsergovaffairsspotService {
    @Resource
    private UsergovaffairsspotDao usergovaffairsspotDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gasid 主键
     * @return 实例对象
     */
    @Override
    public Usergovaffairsspot queryById(Integer gasid) {
        return this.usergovaffairsspotDao.queryById(gasid);
    }

    /**
     * 新增数据
     *
     * @param usergovaffairsspot 实例对象
     * @return 实例对象
     */
    @Override
    public Usergovaffairsspot insert(Usergovaffairsspot usergovaffairsspot) {
        this.usergovaffairsspotDao.insert(usergovaffairsspot);
        return usergovaffairsspot;
    }

    /**
     * 修改数据
     *
     * @param usergovaffairsspot 实例对象
     * @return 实例对象
     */
    @Override
    public Usergovaffairsspot update(Usergovaffairsspot usergovaffairsspot) {
        this.usergovaffairsspotDao.update(usergovaffairsspot);
        return this.queryById(usergovaffairsspot.getGasid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gasid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gasid) {
        return this.usergovaffairsspotDao.deleteById(gasid) > 0;
    }
}
