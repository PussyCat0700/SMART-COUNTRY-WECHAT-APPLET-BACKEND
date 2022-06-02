package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairs;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Usergovaffairs)表控制层
 *
 * @author makejava
 * @since 2022-06-02 22:26:12
 */
@RestController
@RequestMapping("usergovaffairs")
public class UsergovaffairsController {
    /**
     * 服务对象
     */
    @Resource
    private UsergovaffairsService usergovaffairsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Usergovaffairs> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.usergovaffairsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param usergovaffairs 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Usergovaffairs> add(@RequestBody Usergovaffairs usergovaffairs) {
        return ResponseEntity.ok(this.usergovaffairsService.insert(usergovaffairs));
    }

    /**
     * 编辑数据
     *
     * @param usergovaffairs 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Usergovaffairs> edit(@RequestBody Usergovaffairs usergovaffairs) {
        return ResponseEntity.ok(this.usergovaffairsService.update(usergovaffairs));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.usergovaffairsService.deleteById(id));
    }

}

