package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Govaffairsspot;
import com.miniprogram.zhihuicunwu.service.GovaffairsspotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Govaffairsspot)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("govaffairsspot")
public class GovaffairsspotController {
    /**
     * 服务对象
     */
    @Resource
    private GovaffairsspotService govaffairsspotService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Govaffairsspot> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.govaffairsspotService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param govaffairsspot 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Govaffairsspot> add(@RequestBody Govaffairsspot govaffairsspot) {
        return ResponseEntity.ok(this.govaffairsspotService.insert(govaffairsspot));
    }

    /**
     * 编辑数据
     *
     * @param govaffairsspot 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Govaffairsspot> edit(@RequestBody Govaffairsspot govaffairsspot) {
        return ResponseEntity.ok(this.govaffairsspotService.update(govaffairsspot));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.govaffairsspotService.deleteById(id));
    }

}

