package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.PublicationComment;
import com.miniprogram.zhihuicunwu.dao.PublicationCommentDao;
import com.miniprogram.zhihuicunwu.service.PublicationCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PublicationComment)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 14:50:07
 */
@Service("publicationCommentService")
public class PublicationCommentServiceImpl implements PublicationCommentService {
    @Resource
    private PublicationCommentDao publicationCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public PublicationComment queryById(Integer commentId) {
        return this.publicationCommentDao.queryById(commentId);
    }
    
    /**
     * 通过任意字段查询数据列表
     *
     * @param publicationComment 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<PublicationComment> queryAllByAny(PublicationComment publicationComment){
        return this.publicationCommentDao.queryAllByAny(publicationComment);
    }

    /**
     * 新增数据
     *
     * @param publicationComment 实例对象
     * @return 实例对象
     */
    @Override
    public PublicationComment insert(PublicationComment publicationComment) {
        this.publicationCommentDao.insert(publicationComment);
        return publicationComment;
    }

    /**
     * 修改数据
     *
     * @param publicationComment 实例对象
     * @return 实例对象
     */
    @Override
    public PublicationComment update(PublicationComment publicationComment) {
        this.publicationCommentDao.update(publicationComment);
        return this.queryById(publicationComment.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer commentId) {
        return this.publicationCommentDao.deleteById(commentId) > 0;
    }
}
