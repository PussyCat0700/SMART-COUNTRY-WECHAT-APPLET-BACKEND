package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Publicationattach;
import com.miniprogram.zhihuicunwu.dao.PublicationattachDao;
import com.miniprogram.zhihuicunwu.service.PublicationattachService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Publicationattach)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 16:53:54
 */
@Service("publicationattachService")
public class PublicationattachServiceImpl implements PublicationattachService {
    @Resource
    private PublicationattachDao publicationattachDao;

    /**
     * 通过ID查询单条数据
     *
     * @param attachId 主键
     * @return 实例对象
     */
    @Override
    public Publicationattach queryById(Integer attachId) {
        return this.publicationattachDao.queryById(attachId);
    }

    /**
     * 分页查询
     *
     * @param publicationattach 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Publicationattach> queryByPage(Publicationattach publicationattach, PageRequest pageRequest) {
        long total = this.publicationattachDao.count(publicationattach);
        return new PageImpl<>(this.publicationattachDao.queryAllByLimit(publicationattach, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param publicationattach 实例对象
     * @return 实例对象
     */
    @Override
    public Publicationattach insert(Publicationattach publicationattach) {
        this.publicationattachDao.insert(publicationattach);
        return publicationattach;
    }

    /**
     * 修改数据
     *
     * @param publicationattach 实例对象
     * @return 实例对象
     */
    @Override
    public Publicationattach update(Publicationattach publicationattach) {
        this.publicationattachDao.update(publicationattach);
        return this.queryById(publicationattach.getAttachId());
    }

    /**
     * 通过主键删除数据
     *
     * @param attachId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer attachId) {
        return this.publicationattachDao.deleteById(attachId) > 0;
    }
}
