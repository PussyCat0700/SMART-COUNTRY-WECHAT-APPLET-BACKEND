package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.PublicationComment;
import java.util.List;

/**
 * (PublicationComment)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 14:50:07
 */
public interface PublicationCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    PublicationComment queryById(Integer commentId);

    /**
     * 通过任意字段查询数据列表
     *
     * @param publicationComment 实例对象
     * @return 实例对象列表
     */
    List<PublicationComment> queryAllByAny(PublicationComment publicationComment);
    
    /**
     * 新增数据
     *
     * @param publicationComment 实例对象
     * @return 实例对象
     */
    PublicationComment insert(PublicationComment publicationComment);

    /**
     * 修改数据
     *
     * @param publicationComment 实例对象
     * @return 实例对象
     */
    PublicationComment update(PublicationComment publicationComment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer commentId);

}
