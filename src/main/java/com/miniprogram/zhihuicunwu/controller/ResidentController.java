package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Resident;
import com.miniprogram.zhihuicunwu.service.ResidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Resident)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("resident")
public class ResidentController {
    /**
     * 服务对象
     */
    @Resource
    private ResidentService residentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Resident> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.residentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param resident 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Resident> add(@RequestBody Resident resident) {
        return ResponseEntity.ok(this.residentService.insert(resident));
    }

    /**
     * 编辑数据
     *
     * @param resident 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Resident> edit(@RequestBody Resident resident) {
        return ResponseEntity.ok(this.residentService.update(resident));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.residentService.deleteById(id));
    }

}

