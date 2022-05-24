package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Publish;
import com.miniprogram.zhihuicunwu.service.PublishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Publish)表控制层
 *
 * @author makejava
 * @since 2022-05-24 17:56:23
 */
@RestController
@RequestMapping("publish")
public class PublishController {
    /**
     * 服务对象
     */
    @Resource
    private PublishService publishService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Publish> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.publishService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param publish 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Publish> add(@RequestBody Publish publish) {
        return ResponseEntity.ok(this.publishService.insert(publish));
    }

    /**
     * 编辑数据
     *
     * @param publish 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Publish> edit(@RequestBody Publish publish) {
        return ResponseEntity.ok(this.publishService.update(publish));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.publishService.deleteById(id));
    }

}

