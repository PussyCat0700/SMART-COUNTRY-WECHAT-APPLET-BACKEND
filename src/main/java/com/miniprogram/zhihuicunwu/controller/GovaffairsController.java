package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.*;
import com.miniprogram.zhihuicunwu.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * (Govaffairs)表控制层
 *
 * @author makejava
 * @since 2022-06-02 22:26:09
 */
@RestController
@RequestMapping("govaffairs")
public class GovaffairsController {
    /**
     * 服务对象
     */
    @Resource
    private GovaffairsService govaffairsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "{id}", produces="application/json;charset=UTF-8")
    public ResponseEntity<Govaffairs> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.govaffairsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param govaffairs 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Govaffairs> add(@RequestBody Govaffairs govaffairs) {
        return ResponseEntity.ok(this.govaffairsService.insert(govaffairs));
    }

    /**
     * 编辑数据
     *
     * @param govaffairs 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Govaffairs> edit(@RequestBody Govaffairs govaffairs) {
        return ResponseEntity.ok(this.govaffairsService.update(govaffairs));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.govaffairsService.deleteById(id));
    }

}

