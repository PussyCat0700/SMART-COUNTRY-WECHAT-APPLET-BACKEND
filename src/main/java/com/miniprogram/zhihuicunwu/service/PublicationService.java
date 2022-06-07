package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Publication)表服务接口
 *
 * @author makejava
 * @since 2022-06-06 16:54:56
 */
public interface PublicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Publication queryById(Integer pid);

    //根据标题模糊查询
    List<Publication> queryFuzzyByTitle(String keywords);

    /**
     * 分页查询
     *
     * @param publication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Publication> queryByPage(Publication publication, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param publication 实例对象
     * @return 实例对象
     */
    Publication insert(Publication publication);

    /**
     * 修改数据
     *
     * @param publication 实例对象
     * @return 实例对象
     */
    Publication update(Publication publication);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pid);

}
