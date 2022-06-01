package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Work;
import com.miniprogram.zhihuicunwu.service.WorkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Work)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("work")
public class WorkController {
    /**
     * 服务对象
     */
    @Resource
    private WorkService workService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Work> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.workService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param work 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Work> add(@RequestBody Work work) {
        return ResponseEntity.ok(this.workService.insert(work));
    }

    /**
     * 编辑数据
     *
     * @param work 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Work> edit(@RequestBody Work work) {
        return ResponseEntity.ok(this.workService.update(work));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.workService.deleteById(id));
    }

}

