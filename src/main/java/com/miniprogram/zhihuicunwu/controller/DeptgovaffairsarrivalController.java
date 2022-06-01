package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Deptgovaffairsarrival;
import com.miniprogram.zhihuicunwu.service.DeptgovaffairsarrivalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Deptgovaffairsarrival)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("deptgovaffairsarrival")
public class DeptgovaffairsarrivalController {
    /**
     * 服务对象
     */
    @Resource
    private DeptgovaffairsarrivalService deptgovaffairsarrivalService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Deptgovaffairsarrival> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.deptgovaffairsarrivalService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param deptgovaffairsarrival 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Deptgovaffairsarrival> add(@RequestBody Deptgovaffairsarrival deptgovaffairsarrival) {
        return ResponseEntity.ok(this.deptgovaffairsarrivalService.insert(deptgovaffairsarrival));
    }

    /**
     * 编辑数据
     *
     * @param deptgovaffairsarrival 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Deptgovaffairsarrival> edit(@RequestBody Deptgovaffairsarrival deptgovaffairsarrival) {
        return ResponseEntity.ok(this.deptgovaffairsarrivalService.update(deptgovaffairsarrival));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.deptgovaffairsarrivalService.deleteById(id));
    }

}

