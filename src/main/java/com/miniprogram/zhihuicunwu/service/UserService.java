package com.miniprogram.zhihuicunwu.service;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.User;

import java.io.IOException;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    User queryById(Integer uid);

    JSONObject queryByThirdSessionKey(String thirdSessionKey, JSONObject userInfo) throws IOException;

    User queryByOpenId(String openId);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

}
