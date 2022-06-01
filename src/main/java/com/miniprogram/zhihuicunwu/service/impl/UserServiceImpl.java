package com.miniprogram.zhihuicunwu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.dao.UserDao;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer uid) {
        return this.userDao.queryById(uid);
    }

    @Override
    public User queryOrRegisterByOpenId(String openID, JSONObject userInfo) {
        User u = this.userDao.queryByOpenID(openID);
        if(u==null){
            u = User.parseFromJSON(userInfo);
            u.setUwxid(openID); // 暂时无法获取
            if(this.userDao.insert(u)>0){
                return u;
            }else{
                return null;
            }
        }
        return u;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uid) {
        return this.userDao.deleteById(uid) > 0;
    }
}
