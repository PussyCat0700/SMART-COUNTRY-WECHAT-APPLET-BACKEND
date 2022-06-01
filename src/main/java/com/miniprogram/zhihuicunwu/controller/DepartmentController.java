package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Department;
import com.miniprogram.zhihuicunwu.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Department> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.departmentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param department 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Department> add(@RequestBody Department department) {
        return ResponseEntity.ok(this.departmentService.insert(department));
    }

    /**
     * 编辑数据
     *
     * @param department 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Department> edit(@RequestBody Department department) {
        return ResponseEntity.ok(this.departmentService.update(department));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.departmentService.deleteById(id));
    }

}

