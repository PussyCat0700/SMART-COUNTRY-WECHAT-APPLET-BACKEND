package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairs;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Deptgovaffairs)表控制层
 *
 * @author makejava
 * @since 2022-06-05 15:53:28
 */
@RestController
@RequestMapping("deptgovaffairs")
public class DeptgovaffairsController {
    /**
     * 服务对象
     */
    @Resource
    private DeptgovaffairsService deptgovaffairsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Deptgovaffairs> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.deptgovaffairsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param deptgovaffairs 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Deptgovaffairs> add(@RequestBody Deptgovaffairs deptgovaffairs) {
        return ResponseEntity.ok(this.deptgovaffairsService.insert(deptgovaffairs));
    }

    /**
     * 编辑数据
     *
     * @param deptgovaffairs 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Deptgovaffairs> edit(@RequestBody Deptgovaffairs deptgovaffairs) {
        return ResponseEntity.ok(this.deptgovaffairsService.update(deptgovaffairs));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.deptgovaffairsService.deleteById(id));
    }

}

