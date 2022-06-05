package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairs;
import com.miniprogram.zhihuicunwu.dao.UsergovaffairsDao;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Usergovaffairs)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 15:31:44
 */
@Service("usergovaffairsService")
public class UsergovaffairsServiceImpl implements UsergovaffairsService {
    @Resource
    private UsergovaffairsDao usergovaffairsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param usergaid 主键
     * @return 实例对象
     */
    @Override
    public Usergovaffairs queryById(Integer usergaid) {
        return this.usergovaffairsDao.queryById(usergaid);
    }
    
    /**
     * 通过任意字段查询数据列表
     *
     * @param usergovaffairs 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<Usergovaffairs> queryAllByAny(Usergovaffairs usergovaffairs){
        return this.usergovaffairsDao.queryAllByAny(usergovaffairs);
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
        return this.queryById(usergovaffairs.getUsergaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param usergaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer usergaid) {
        return this.usergovaffairsDao.deleteById(usergaid) > 0;
    }
}
