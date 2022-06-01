package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Govaffairsarrival;
import com.miniprogram.zhihuicunwu.service.GovaffairsarrivalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Govaffairsarrival)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("govaffairsarrival")
public class GovaffairsarrivalController {
    /**
     * 服务对象
     */
    @Resource
    private GovaffairsarrivalService govaffairsarrivalService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Govaffairsarrival> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.govaffairsarrivalService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param govaffairsarrival 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Govaffairsarrival> add(@RequestBody Govaffairsarrival govaffairsarrival) {
        return ResponseEntity.ok(this.govaffairsarrivalService.insert(govaffairsarrival));
    }

    /**
     * 编辑数据
     *
     * @param govaffairsarrival 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Govaffairsarrival> edit(@RequestBody Govaffairsarrival govaffairsarrival) {
        return ResponseEntity.ok(this.govaffairsarrivalService.update(govaffairsarrival));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.govaffairsarrivalService.deleteById(id));
    }

}

