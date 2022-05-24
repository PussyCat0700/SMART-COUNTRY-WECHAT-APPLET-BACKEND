package com.miniprogram.zhihuicunwu.controller;

import com.miniprogram.zhihuicunwu.entity.Feedback;
import com.miniprogram.zhihuicunwu.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Feedback)表控制层
 *
 * @author makejava
 * @since 2022-05-24 17:56:22
 */
@RestController
@RequestMapping("feedback")
public class FeedbackController {
    /**
     * 服务对象
     */
    @Resource
    private FeedbackService feedbackService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Feedback> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.feedbackService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param feedback 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Feedback> add(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(this.feedbackService.insert(feedback));
    }

    /**
     * 编辑数据
     *
     * @param feedback 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Feedback> edit(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(this.feedbackService.update(feedback));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.feedbackService.deleteById(id));
    }

}

