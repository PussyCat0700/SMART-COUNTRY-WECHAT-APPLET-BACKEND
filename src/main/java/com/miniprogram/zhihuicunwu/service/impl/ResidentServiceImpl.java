package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Resident;
import com.miniprogram.zhihuicunwu.dao.ResidentDao;
import com.miniprogram.zhihuicunwu.service.ResidentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Resident)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("residentService")
public class ResidentServiceImpl implements ResidentService {
    @Resource
    private ResidentDao residentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public Resident queryById(Integer uid) {
        return this.residentDao.queryById(uid);
    }

    @Override
    public List<Resident> queryByCid(Integer cid) { return this.residentDao.queryByCid(cid); }

    /**
     * 新增数据
     *
     * @param resident 实例对象
     * @return 实例对象
     */
    @Override
    public Resident insert(Resident resident) {
        this.residentDao.insert(resident);
        return resident;
    }

    /**
     * 修改数据
     *
     * @param resident 实例对象
     * @return 实例对象
     */
    @Override
    public Resident update(Resident resident) {
        this.residentDao.update(resident);
        return this.queryById(resident.getUid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uid) {
        return this.residentDao.deleteById(uid) > 0;
    }
}
