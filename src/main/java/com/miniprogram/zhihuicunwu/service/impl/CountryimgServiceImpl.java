package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Countryimg;
import com.miniprogram.zhihuicunwu.dao.CountryimgDao;
import com.miniprogram.zhihuicunwu.service.CountryimgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Countryimg)表服务实现类
 *
 * @author makejava
 * @since 2022-06-12 17:41:11
 */
@Service("countryimgService")
public class CountryimgServiceImpl implements CountryimgService {
    @Resource
    private CountryimgDao countryimgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    @Override
    public Countryimg queryById(Integer imgId) {
        return this.countryimgDao.queryById(imgId);
    }
    
    /**
     * 通过任意字段查询数据列表
     *
     * @param countryimg 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<Countryimg> queryAllByAny(Countryimg countryimg){
        return this.countryimgDao.queryAllByAny(countryimg);
    }

    /**
     * 新增数据
     *
     * @param countryimg 实例对象
     * @return 实例对象
     */
    @Override
    public Countryimg insert(Countryimg countryimg) {
        this.countryimgDao.insert(countryimg);
        return countryimg;
    }

    /**
     * 修改数据
     *
     * @param countryimg 实例对象
     * @return 实例对象
     */
    @Override
    public Countryimg update(Countryimg countryimg) {
        this.countryimgDao.update(countryimg);
        return this.queryById(countryimg.getImgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer imgId) {
        return this.countryimgDao.deleteById(imgId) > 0;
    }
}
