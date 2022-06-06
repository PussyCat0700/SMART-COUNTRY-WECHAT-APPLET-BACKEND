package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Publicationpic;
import com.miniprogram.zhihuicunwu.dao.PublicationpicDao;
import com.miniprogram.zhihuicunwu.service.PublicationpicService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Publicationpic)表服务实现类
 *
 * @author makejava
 * @since 2022-06-06 16:54:05
 */
@Service("publicationpicService")
public class PublicationpicServiceImpl implements PublicationpicService {
    @Resource
    private PublicationpicDao publicationpicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    @Override
    public Publicationpic queryById(Integer imgId) {
        return this.publicationpicDao.queryById(imgId);
    }

    /**
     * 分页查询
     *
     * @param publicationpic 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Publicationpic> queryByPage(Publicationpic publicationpic, PageRequest pageRequest) {
        long total = this.publicationpicDao.count(publicationpic);
        return new PageImpl<>(this.publicationpicDao.queryAllByLimit(publicationpic, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param publicationpic 实例对象
     * @return 实例对象
     */
    @Override
    public Publicationpic insert(Publicationpic publicationpic) {
        this.publicationpicDao.insert(publicationpic);
        return publicationpic;
    }

    /**
     * 修改数据
     *
     * @param publicationpic 实例对象
     * @return 实例对象
     */
    @Override
    public Publicationpic update(Publicationpic publicationpic) {
        this.publicationpicDao.update(publicationpic);
        return this.queryById(publicationpic.getImgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer imgId) {
        return this.publicationpicDao.deleteById(imgId) > 0;
    }
}
