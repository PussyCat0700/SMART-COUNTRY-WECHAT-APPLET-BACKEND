package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Govaffairneed;
import com.miniprogram.zhihuicunwu.service.GovaffairneedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Govaffairneed)表控制层
 *
 * @author makejava
 * @since 2022-06-03 11:40:55
 */
@RestController
@RequestMapping("govaffairneed")
public class GovaffairneedController {
    /**
     * 服务对象
     */
    @Resource
    private GovaffairneedService govaffairneedService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Govaffairneed> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.govaffairneedService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param govaffairneed 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Govaffairneed> add(@RequestBody Govaffairneed govaffairneed) {
        return ResponseEntity.ok(this.govaffairneedService.insert(govaffairneed));
    }

    /**
     * 编辑数据
     *
     * @param govaffairneed 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Govaffairneed> edit(@RequestBody Govaffairneed govaffairneed) {
        return ResponseEntity.ok(this.govaffairneedService.update(govaffairneed));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.govaffairneedService.deleteById(id));
    }

}

