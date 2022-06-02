package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.dao.UsergovaffairsDao;
import com.miniprogram.zhihuicunwu.entity.Usergovaffairs;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Usergovaffairs)表服务实现类
 *
 * @author makejava
 * @since 2022-06-02 22:26:12
 */
@Service("usergovaffairsService")
public class UsergovaffairsServiceImpl implements UsergovaffairsService {
    @Resource
    private UsergovaffairsDao usergovaffairsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gaid 主键
     * @return 实例对象
     */
    @Override
    public Usergovaffairs queryById(Integer gaid) {
        return this.usergovaffairsDao.queryById(gaid);
    }

    /**
     * 新增数据
     *
     * @param usergovaffairs 实例对象
     * @return 实例对象
     */
    @Override
    public Usergovaffairs insert(Usergovaffairs usergovaffairs) {
        this.usergovaffairsDao.insert(usergovaffairs);
        return usergovaffairs;
    }

    /**
     * 修改数据
     *
     * @param usergovaffairs 实例对象
     * @return 实例对象
     */
    @Override
    public Usergovaffairs update(Usergovaffairs usergovaffairs) {
        this.usergovaffairsDao.update(usergovaffairs);
        return this.queryById(usergovaffairs.getGaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gaid) {
        return this.usergovaffairsDao.deleteById(gaid) > 0;
    }
}
