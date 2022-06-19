package com.miniprogram.zhihuicunwu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.dao.ResidentDao;
import com.miniprogram.zhihuicunwu.dao.WorkDao;
import com.miniprogram.zhihuicunwu.entity.Resident;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.dao.UserDao;
import com.miniprogram.zhihuicunwu.entity.Work;
import com.miniprogram.zhihuicunwu.service.CountryService;
import com.miniprogram.zhihuicunwu.service.DepartmentService;
import com.miniprogram.zhihuicunwu.service.UserService;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

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
    @Resource
    private ResidentDao residentDao;
    @Resource
    private WorkDao workDao;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private CountryService countryService;

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
    public JSONObject queryByThirdSessionKey(String thirdSessionKey, JSONObject userInfo) throws IOException {
        JSONObject jsonObject = new JSONObject();
        User u = this.userDao.queryBy3rdSessionKey(thirdSessionKey);
        if(u!=null) {
            Integer uid = u.getUid();
            User u2 = User.parseFromJSON(userInfo);
            u.mergeChanges(u2);
            this.userDao.update(u);
            u.setUphoto(ImageIOUtils.getUrlFromDBRecord(u.getUphoto()));

            Resident r = this.residentDao.queryById(uid);
            Work w = this.workDao.queryByUId(uid);
            jsonObject.put("user", u);
            jsonObject.put("country", r == null ? null : countryService.queryById(r.getCid()));
            jsonObject.put("work", w);
            jsonObject.put("department", w == null ? null : this.departmentService.queryById(w.getDid()));
        }else{
            jsonObject.put("error", String.format("未找到%s的第三方key对应的该用户信息", thirdSessionKey));
        }
        return jsonObject;
    }

    @Override
    public User queryByOpenId(String openId) {
        return this.userDao.queryByOpenID(openId);
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
