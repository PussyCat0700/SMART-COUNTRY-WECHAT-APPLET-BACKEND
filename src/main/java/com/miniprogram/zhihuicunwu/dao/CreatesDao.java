package com.miniprogram.zhihuicunwu.dao;

import com.miniprogram.zhihuicunwu.entity.Creates;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Creates)�����ݿ���ʲ�
 *
 * @author makejava
 * @since 2022-06-15 21:17:04
 */
public interface CreatesDao {

    /**
     * ͨ��ID��ѯ��������
     *
     * @param cid ����
     * @return ʵ������
     */
    Creates queryById(Integer cid);

    Creates queryByUid(Integer uid);

    /**
     * ��ѯָ��������
     *
     * @param creates ��ѯ����
     * @param pageable         ��ҳ����
     * @return �����б�
     */
    List<Creates> queryAllByLimit(Creates creates, @Param("pageable") Pageable pageable);

    /**
     * �����ѯ���б�
     * @param creates ��ѯ����
     * @return �����б�
     */
    List<Creates> queryAllByAny(Creates creates);
     
    /**
     * ͳ��������
     *
     * @param creates ��ѯ����
     * @return ������
     */
    long count(Creates creates);

    /**
     * ��������
     *
     * @param creates ʵ������
     * @return Ӱ������
     */
    int insert(Creates creates);

    /**
     * �����������ݣ�MyBatisԭ��foreach������
     *
     * @param entities List<Creates> ʵ�������б�
     * @return Ӱ������
     */
    int insertBatch(@Param("entities") List<Creates> entities);

    /**
     * ���������������������ݣ�MyBatisԭ��foreach������
     *
     * @param entities List<Creates> ʵ�������б�
     * @return Ӱ������
     * @throws org.springframework.jdbc.BadSqlGrammarException ����ǿ�List��ʱ�����SQL��������쳣��������У�����
     */
    int insertOrUpdateBatch(@Param("entities") List<Creates> entities);

    /**
     * �޸�����
     *
     * @param creates ʵ������
     * @return Ӱ������
     */
    int update(Creates creates);

    /**
     * ͨ������ɾ������
     *
     * @param uid ����
     * @return Ӱ������
     */
    int deleteById(Integer uid);

}

