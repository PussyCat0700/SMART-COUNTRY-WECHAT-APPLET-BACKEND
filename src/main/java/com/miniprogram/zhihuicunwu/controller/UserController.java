package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
//    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(this.userService.queryById(id));
//    }
    //TODO:后端测试
    public User queryById(@PathVariable("id") Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * login Or register
     */
    @PostMapping("/login")
    public ResponseEntity<JSONObject> loginOrRegister(@RequestBody JSONObject params){
        String encryptedData = params.getString("encryptedData");
        // TODO 解密
        JSONObject userInfo = params.getJSONObject("userInfo");
        return ResponseEntity.ok(this.userService.queryOrRegisterByOpenId(encryptedData, userInfo));
    }

    /**
     * 编辑数据
     *
     * @param params 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<JSONObject> edit(@RequestBody JSONObject params) {
        User user = this.userService.queryById(params.getInteger("uid"));
        JSONObject ret = new JSONObject();

        user.setUname(params.getString("uname"));
        user.setUgender(params.getInteger("gender"));
        user.setUage(params.getInteger("age"));
        user.setUphone(params.getString("phoneNumber"));

        if (this.userService.update(user) != null)
        {
            ret.put("result", true);
        }
        else
        {
            ret.put("result", false);
        }

        return ResponseEntity.ok(ret);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

