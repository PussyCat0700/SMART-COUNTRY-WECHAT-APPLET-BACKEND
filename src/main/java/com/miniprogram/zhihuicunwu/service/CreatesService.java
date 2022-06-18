package com.miniprogram.zhihuicunwu.service;

import com.miniprogram.zhihuicunwu.entity.Creates;
import java.util.List;

/**
 * (Creates)�����ӿ�
 *
 * @author makejava
 * @since 2022-06-15 21:17:04
 */
public interface CreatesService {

    /**
     * ͨ��ID��ѯ��������
     *
     * @param uid ����
     * @return ʵ������
     */
    Creates queryById(Integer uid);

    /**
     * ͨ�������ֶβ�ѯ�����б�
     *
     * @param creates ʵ������
     * @return ʵ�������б�
     */
    List<Creates> queryAllByAny(Creates creates);
    
    /**
     * ��������
     *
     * @param creates ʵ������
     * @return ʵ������
     */
    Creates insert(Creates creates);

    /**
     * �޸�����
     *
     * @param creates ʵ������
     * @return ʵ������
     */
    Creates update(Creates creates);

    /**
     * ͨ������ɾ������
     *
     * @param uid ����
     * @return �Ƿ�ɹ�
     */
    boolean deleteById(Integer uid);

}
