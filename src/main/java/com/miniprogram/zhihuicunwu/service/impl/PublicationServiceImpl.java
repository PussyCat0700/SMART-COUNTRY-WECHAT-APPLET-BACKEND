package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Publication;
import com.miniprogram.zhihuicunwu.dao.PublicationDao;
import com.miniprogram.zhihuicunwu.service.PublicationService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Publication)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 16:54:56
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

    @Override
    public List<Publication> queryFuzzyByTitle(String keywords) { return this.publicationDao.queryFuzzyByTitle(keywords); }

    /**
     * 分页查询
     *
     * @param publication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Publication> queryByPage(Publication publication, PageRequest pageRequest) {
        long total = this.publicationDao.count(publication);
        return new PageImpl<>(this.publicationDao.queryAllByLimit(publication, pageRequest), pageRequest, total);
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
