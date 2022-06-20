package com.miniprogram.zhihuicunwu.service.impl;

import com.miniprogram.zhihuicunwu.entity.Creates;
import com.miniprogram.zhihuicunwu.dao.CreatesDao;
import com.miniprogram.zhihuicunwu.service.CreatesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Creates)�����ʵ����
 *
 * @author makejava
 * @since 2022-06-15 21:17:04
 */
@Service("createsService")
public class CreatesServiceImpl implements CreatesService {
    @Resource
    private CreatesDao createsDao;

    /**
     * ͨ��ID��ѯ��������
     *
     * @param cid ����
     * @return ʵ������
     */
    @Override
    public Creates queryById(Integer cid) {
        return this.createsDao.queryById(cid);
    }

    @Override
    public Creates queryByUid(Integer uid) { return this.createsDao.queryByUid(uid); }
    
    /**
     * ͨ�������ֶβ�ѯ�����б�
     *
     * @param creates ʵ������
     * @return ʵ�������б�
     */
     @Override
    public List<Creates> queryAllByAny(Creates creates){
        return this.createsDao.queryAllByAny(creates);
    }

    /**
     * ��������
     *
     * @param creates ʵ������
     * @return ʵ������
     */
    @Override
    public Creates insert(Creates creates) {
        this.createsDao.insert(creates);
        return creates;
    }

    /**
     * �޸�����
     *
     * @param creates ʵ������
     * @return ʵ������
     */
    @Override
    public Creates update(Creates creates) {
        this.createsDao.update(creates);
        return this.queryById(creates.getUid());
    }

    /**
     * ͨ������ɾ������
     *
     * @param uid ����
     * @return �Ƿ�ɹ�
     */
    @Override
    public boolean deleteById(Integer uid) {
        return this.createsDao.deleteById(uid) > 0;
    }
}
