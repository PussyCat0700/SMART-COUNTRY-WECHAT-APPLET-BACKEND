package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.*;
import com.miniprogram.zhihuicunwu.externalservices.LoginUtils;
import com.miniprogram.zhihuicunwu.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

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
    @Resource
    private ResidentService residentService;
    @Resource
    private CreatesService createsService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private WorkService workService;
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
    @PostMapping("/getsskey")
    public ResponseEntity<JSONObject> getSessionKeyAndRegister(@RequestBody JSONObject params) throws IOException {
        String code = params.getString("code");
        JSONObject decodeResult = LoginUtils.INSTANCE.getSessionResult(code, this.userService);
        return ResponseEntity.ok(decodeResult);
    }
    @PostMapping("/login")
    public ResponseEntity<JSONObject> login(@RequestHeader(name = "Cookie") String cookie, @RequestBody JSONObject params) throws IOException {
        JSONObject userInfo = params.getJSONObject("userInfo");
        return ResponseEntity.ok(this.userService.queryByThirdSessionKey(cookie, userInfo));
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
        user.setRealName(params.getString("realname"));

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

    @PutMapping("status")
    public ResponseEntity<JSONObject> editStatus(@RequestBody JSONObject params) {
        User user = this.userService.queryById(params.getInteger("uid"));
        JSONObject ret = new JSONObject();

        if (user != null)
        {
            ret.put("result", true);
            user.setStatus(4);
            this.userService.update(user);

            Creates creates = this.createsService.queryByUid(params.getInteger("uid"));
            Resident resident = new Resident();
            resident.setUid(params.getInteger("uid"));
            resident.setCid(creates.getCid());
            this.residentService.insert(resident);

            //创建名为村长的部门
            Department department = new Department();
            department.setCid(creates.getCid());
            department.setDname("村");
            department.setDdescription("仅用于村长发布公告");
            department.setDaddress("无");
            department.setDphone("无");
            String dcode = creates.getCid() + "-" + user.getUid();
            department.setDcode(dcode);
            this.departmentService.insert(department);

            //加入work表
            Work work = new Work();
            work.setWname("负责人");
            work.setUid(user.getUid());
            work.setDid(department.getDid());
            this.workService.insert(work);
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

