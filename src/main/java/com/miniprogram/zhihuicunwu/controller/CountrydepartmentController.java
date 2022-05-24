package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Countrydepartment;
import com.miniprogram.zhihuicunwu.service.CountrydepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Countrydepartment)表控制层
 *
 * @author makejava
 * @since 2022-05-24 17:56:20
 */
@RestController
@RequestMapping("countrydepartment")
public class CountrydepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private CountrydepartmentService countrydepartmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Countrydepartment> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.countrydepartmentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param countrydepartment 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Countrydepartment> add(@RequestBody Countrydepartment countrydepartment) {
        return ResponseEntity.ok(this.countrydepartmentService.insert(countrydepartment));
    }

    /**
     * 编辑数据
     *
     * @param countrydepartment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Countrydepartment> edit(@RequestBody Countrydepartment countrydepartment) {
        return ResponseEntity.ok(this.countrydepartmentService.update(countrydepartment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.countrydepartmentService.deleteById(id));
    }

}

