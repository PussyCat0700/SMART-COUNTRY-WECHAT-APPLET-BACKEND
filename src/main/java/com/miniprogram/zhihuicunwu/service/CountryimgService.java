package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Countryimg;
import java.util.List;

/**
 * (Countryimg)表服务接口
 *
 * @author makejava
 * @since 2022-06-12 17:41:10
 */
public interface CountryimgService {

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    Countryimg queryById(Integer imgId);

    /**
     * 通过任意字段查询数据列表
     *
     * @param countryimg 实例对象
     * @return 实例对象列表
     */
    List<Countryimg> queryAllByAny(Countryimg countryimg);
    
    /**
     * 新增数据
     *
     * @param countryimg 实例对象
     * @return 实例对象
     */
    Countryimg insert(Countryimg countryimg);

    /**
     * 修改数据
     *
     * @param countryimg 实例对象
     * @return 实例对象
     */
    Countryimg update(Countryimg countryimg);

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer imgId);

}
