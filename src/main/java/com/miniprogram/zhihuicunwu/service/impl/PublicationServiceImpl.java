package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Publication;
import com.miniprogram.zhihuicunwu.dao.PublicationDao;
import com.miniprogram.zhihuicunwu.service.PublicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Publication)表服务实现类
 *
 * @author makejava
 * @since 2022-05-24 17:56:23
 */
@Service("publicationService")
public class PublicationServiceImpl implements PublicationService {
    @Resource
    private PublicationDao publicationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Publication queryById(Integer pid) {
        return this.publicationDao.queryById(pid);
    }

    /**
     * 新增数据
     *
     * @param publication 实例对象
     * @return 实例对象
     */
    @Override
    public Publication insert(Publication publication) {
        this.publicationDao.insert(publication);
        return publication;
    }

    /**
     * 修改数据
     *
     * @param publication 实例对象
     * @return 实例对象
     */
    @Override
    public Publication update(Publication publication) {
        this.publicationDao.update(publication);
        return this.queryById(publication.getPid());
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pid) {
        return this.publicationDao.deleteById(pid) > 0;
    }
}
