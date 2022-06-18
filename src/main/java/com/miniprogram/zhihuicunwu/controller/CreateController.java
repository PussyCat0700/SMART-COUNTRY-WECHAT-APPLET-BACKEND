package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Creates;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.CreatesService;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Create)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("create")
public class CreateController {
    /**
     * 服务对象
     */
    @Resource
    private CreatesService createsService;
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Creates> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.createsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param create 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Creates> add(@RequestBody Creates create) {
        return ResponseEntity.ok(this.createsService.insert(create));
    }

    /**
     * 编辑数据
     *
     * @param create 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Creates> edit(@RequestBody Creates create) {
        return ResponseEntity.ok(this.createsService.update(create));
    }

    @PutMapping("/setting")
    public ResponseEntity<JSONObject> setManager(@RequestBody JSONObject params) {
        JSONObject ret = new JSONObject();
        Creates create = this.createsService.queryById(params.getInteger("cid"));

        if(create != null)
        {
            this.createsService.deleteById(params.getInteger("uid"));
        }
        create = new Creates();
        create.setCid(params.getInteger("cid"));
        create.setUid(params.getInteger("uid"));
        this.createsService.insert(create);

        User user = this.userService.queryById(params.getInteger("uid"));
        user.setStatus(4);
        this.userService.update(user);

        ret.put("result", true);

        return ResponseEntity.ok(ret);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{uid}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("uid") Integer id) {
        return ResponseEntity.ok(this.createsService.deleteById(id));
    }

}

