package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Usergovaffairsarrival;
import com.miniprogram.zhihuicunwu.service.UsergovaffairsarrivalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Usergovaffairsarrival)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
@RestController
@RequestMapping("usergovaffairsarrival")
public class UsergovaffairsarrivalController {
    /**
     * 服务对象
     */
    @Resource
    private UsergovaffairsarrivalService usergovaffairsarrivalService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Usergovaffairsarrival> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.usergovaffairsarrivalService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param usergovaffairsarrival 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Usergovaffairsarrival> add(@RequestBody Usergovaffairsarrival usergovaffairsarrival) {
        return ResponseEntity.ok(this.usergovaffairsarrivalService.insert(usergovaffairsarrival));
    }

    /**
     * 编辑数据
     *
     * @param usergovaffairsarrival 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Usergovaffairsarrival> edit(@RequestBody Usergovaffairsarrival usergovaffairsarrival) {
        return ResponseEntity.ok(this.usergovaffairsarrivalService.update(usergovaffairsarrival));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.usergovaffairsarrivalService.deleteById(id));
    }

}

