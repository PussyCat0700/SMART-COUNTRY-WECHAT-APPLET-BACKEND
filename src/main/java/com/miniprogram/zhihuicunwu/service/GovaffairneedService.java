package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Govaffairneed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Govaffairneed)表服务接口
 *
 * @author makejava
 * @since 2022-06-06 17:19:04
 */
public interface GovaffairneedService {

    /**
     * 通过ID查询单条数据
     *
     * @param needId 主键
     * @return 实例对象
     */
    Govaffairneed queryById(Integer needId);

    /**
     * 分页查询
     *
     * @param govaffairneed 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Govaffairneed> queryByPage(Govaffairneed govaffairneed, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param govaffairneed 实例对象
     * @return 实例对象
     */
    Govaffairneed insert(Govaffairneed govaffairneed);

    /**
     * 修改数据
     *
     * @param govaffairneed 实例对象
     * @return 实例对象
     */
    Govaffairneed update(Govaffairneed govaffairneed);

    /**
     * 通过主键删除数据
     *
     * @param needId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer needId);

}
