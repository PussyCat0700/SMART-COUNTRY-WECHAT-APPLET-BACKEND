package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Countryimg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Countryimg)表服务接口
 *
 * @author makejava
 * @since 2022-06-07 13:21:23
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
     * 分页查询
     *
     * @param countryimg 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Countryimg> queryByPage(Countryimg countryimg, PageRequest pageRequest);

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
