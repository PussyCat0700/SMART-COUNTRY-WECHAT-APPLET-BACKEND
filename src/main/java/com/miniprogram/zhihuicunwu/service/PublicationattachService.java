package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Publicationattach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Publicationattach)表服务接口
 *
 * @author makejava
 * @since 2022-06-06 16:53:53
 */
public interface PublicationattachService {

    /**
     * 通过ID查询单条数据
     *
     * @param attachId 主键
     * @return 实例对象
     */
    Publicationattach queryById(Integer attachId);

    /**
     * 分页查询
     *
     * @param publicationattach 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Publicationattach> queryByPage(Publicationattach publicationattach, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param publicationattach 实例对象
     * @return 实例对象
     */
    Publicationattach insert(Publicationattach publicationattach);

    /**
     * 修改数据
     *
     * @param publicationattach 实例对象
     * @return 实例对象
     */
    Publicationattach update(Publicationattach publicationattach);

    /**
     * 通过主键删除数据
     *
     * @param attachId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer attachId);

}
