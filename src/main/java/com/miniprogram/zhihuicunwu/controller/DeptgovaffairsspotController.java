package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairsspot;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsspotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Deptgovaffairsspot)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("deptgovaffairsspot")
public class DeptgovaffairsspotController {
    /**
     * 服务对象
     */
    @Resource
    private DeptgovaffairsspotService deptgovaffairsspotService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Deptgovaffairsspot> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.deptgovaffairsspotService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param deptgovaffairsspot 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Deptgovaffairsspot> add(@RequestBody Deptgovaffairsspot deptgovaffairsspot) {
        return ResponseEntity.ok(this.deptgovaffairsspotService.insert(deptgovaffairsspot));
    }

    /**
     * 编辑数据
     *
     * @param deptgovaffairsspot 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Deptgovaffairsspot> edit(@RequestBody Deptgovaffairsspot deptgovaffairsspot) {
        return ResponseEntity.ok(this.deptgovaffairsspotService.update(deptgovaffairsspot));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.deptgovaffairsspotService.deleteById(id));
    }

}

