package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Publicationpic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Publicationpic)表服务接口
 *
 * @author makejava
 * @since 2022-06-06 16:54:05
 */
public interface PublicationpicService {

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    Publicationpic queryById(Integer imgId);

    List<Publicationpic> queryByPid(Integer pid);

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    Page<Publicationpic> queryByPage(Publicationpic publicationpic, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param publicationpic 实例对象
     * @return 实例对象
     */
    Publicationpic insert(Publicationpic publicationpic);

    /**
     * 修改数据
     *
     * @param publicationpic 实例对象
     * @return 实例对象
     */
    Publicationpic update(Publicationpic publicationpic);

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer imgId);

}
