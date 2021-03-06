package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Application;
import com.miniprogram.zhihuicunwu.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Application)表控制层
 *
 * @author makejava
 * @since 2022-06-06 22:55:44
 */
@RestController
@RequestMapping("application")
public class ApplicationController {
    /**
     * 服务对象
     */
    @Resource
    private ApplicationService applicationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Application> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.applicationService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param application 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Application> add(@RequestBody Application application) {
        return ResponseEntity.ok(this.applicationService.insert(application));
    }

    /**
     * 编辑数据
     *
     * @param application 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Application> edit(@RequestBody Application application) {
        return ResponseEntity.ok(this.applicationService.update(application));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.applicationService.deleteById(id));
    }

}

