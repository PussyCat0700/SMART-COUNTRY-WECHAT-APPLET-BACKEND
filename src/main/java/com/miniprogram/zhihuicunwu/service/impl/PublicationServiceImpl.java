package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Publication;
import com.miniprogram.zhihuicunwu.dao.PublicationDao;
import com.miniprogram.zhihuicunwu.service.PublicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Publication)表服务实现类
 *
 * @author makejava
 * @since 2022-06-08 21:19:32
 */
@Service("publicationService")
public class PublicationServiceImpl implements PublicationService {
    @Resource
    private PublicationDao publicationDao;
    /**
     * 分页查询
     *
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Publication> queryByPage(Pageable pageRequest) {
        return new PageImpl<>(this.publicationDao.queryAllByLimit(pageRequest));
    }

    @Override
    public int countAll()
    {
        return this.publicationDao.countAll();
    }
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
     * 通过任意字段查询数据列表
     *
     * @param publication 实例对象
     * @return 实例对象列表
     */
     @Override
    public List<Publication> queryAllByAny(Publication publication){
        return this.publicationDao.queryAllByAny(publication);
    }

    @Override
    public List<Publication> queryFuzzyByTitle(String keywords) { return this.publicationDao.queryFuzzyByTitle(keywords); }

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
