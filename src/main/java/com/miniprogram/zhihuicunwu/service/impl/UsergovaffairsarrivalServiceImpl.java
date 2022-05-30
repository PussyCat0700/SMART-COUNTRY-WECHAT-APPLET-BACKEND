package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairsarrival;
import com.miniprogram.zhihuicunwu.dao.UsergovaffairsarrivalDao;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsarrivalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Usergovaffairsarrival)表服务实现类
 *
 * @author makejava
 * @since 2022-05-30 21:01:07
 */
@Service("usergovaffairsarrivalService")
public class UsergovaffairsarrivalServiceImpl implements UsergovaffairsarrivalService {
    @Resource
    private UsergovaffairsarrivalDao usergovaffairsarrivalDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gaaid 主键
     * @return 实例对象
     */
    @Override
    public Usergovaffairsarrival queryById(Integer gaaid) {
        return this.usergovaffairsarrivalDao.queryById(gaaid);
    }

    /**
     * 新增数据
     *
     * @param usergovaffairsarrival 实例对象
     * @return 实例对象
     */
    @Override
    public Usergovaffairsarrival insert(Usergovaffairsarrival usergovaffairsarrival) {
        this.usergovaffairsarrivalDao.insert(usergovaffairsarrival);
        return usergovaffairsarrival;
    }

    /**
     * 修改数据
     *
     * @param usergovaffairsarrival 实例对象
     * @return 实例对象
     */
    @Override
    public Usergovaffairsarrival update(Usergovaffairsarrival usergovaffairsarrival) {
        this.usergovaffairsarrivalDao.update(usergovaffairsarrival);
        return this.queryById(usergovaffairsarrival.getGaaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param gaaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gaaid) {
        return this.usergovaffairsarrivalDao.deleteById(gaaid) > 0;
    }
}
