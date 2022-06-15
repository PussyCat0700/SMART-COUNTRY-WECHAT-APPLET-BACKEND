package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Create;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.CreateService;
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
    private CreateService createService;
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Create> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.createService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param create 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Create> add(@RequestBody Create create) {
        return ResponseEntity.ok(this.createService.insert(create));
    }

    /**
     * 编辑数据
     *
     * @param create 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Create> edit(@RequestBody Create create) {
        return ResponseEntity.ok(this.createService.update(create));
    }

    @PutMapping("setting")
    public ResponseEntity<JSONObject> edit(@RequestBody JSONObject params) {
        JSONObject ret = new JSONObject();
        Create create = this.createService.queryById(params.getInteger("uid"));

        if(create != null)
        {
            this.createService.deleteById(params.getInteger("uid"));
        }

        create.setCid(params.getInteger("cid"));
        create.setUid(params.getInteger("uid"));

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
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.createService.deleteById(id));
    }

}

