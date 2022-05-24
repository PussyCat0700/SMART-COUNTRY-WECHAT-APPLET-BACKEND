package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairsspot;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsspotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Usergovaffairsspot)表控制层
 *
 * @author makejava
 * @since 2022-05-24 17:56:25
 */
@RestController
@RequestMapping("usergovaffairsspot")
public class UsergovaffairsspotController {
    /**
     * 服务对象
     */
    @Resource
    private UsergovaffairsspotService usergovaffairsspotService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Usergovaffairsspot> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.usergovaffairsspotService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param usergovaffairsspot 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Usergovaffairsspot> add(@RequestBody Usergovaffairsspot usergovaffairsspot) {
        return ResponseEntity.ok(this.usergovaffairsspotService.insert(usergovaffairsspot));
    }

    /**
     * 编辑数据
     *
     * @param usergovaffairsspot 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Usergovaffairsspot> edit(@RequestBody Usergovaffairsspot usergovaffairsspot) {
        return ResponseEntity.ok(this.usergovaffairsspotService.update(usergovaffairsspot));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.usergovaffairsspotService.deleteById(id));
    }

}

