package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Publication)表服务接口
 *
 * @author makejava
 * @since 2022-06-08 21:19:32
 */
public interface PublicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Publication queryById(Integer pid);

    List<Publication> queryByDid(Integer did);

    //根据标题模糊查询
    List<Publication> queryFuzzyByTitle(String keywords, Integer cid);

    int countAll();

    /**
     * 分页查询
     *
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Publication> queryByPage(Pageable pageRequest, Integer cid);
    /**
     * 通过任意字段查询数据列表
     *
     * @param publication 实例对象
     * @return 实例对象列表
     */
    List<Publication> queryAllByAny(Publication publication);

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
