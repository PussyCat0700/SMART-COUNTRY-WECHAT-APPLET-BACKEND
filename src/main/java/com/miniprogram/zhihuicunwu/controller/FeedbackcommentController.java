package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Feedbackcomment;
import com.miniprogram.zhihuicunwu.service.FeedbackcommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Feedbackcomment)表控制层
 *
 * @author makejava
 * @since 2022-06-18 11:19:00
 */
@RestController
@RequestMapping("feedbackcomment")
public class FeedbackcommentController {
    /**
     * 服务对象
     */
    @Resource
    private FeedbackcommentService feedbackcommentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Feedbackcomment> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.feedbackcommentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param jsonObject 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Feedbackcomment> add(@RequestBody JSONObject jsonObject) {
        Feedbackcomment feedbackcomment = new Feedbackcomment();
        feedbackcomment.setContent(jsonObject.getString("content"));
        feedbackcomment.setFid(jsonObject.getInteger("related_feedback"));
        feedbackcomment.setUid(jsonObject.getInteger("responder"));
        return ResponseEntity.ok(this.feedbackcommentService.insert(feedbackcomment));
    }

    /**
     * 编辑数据
     *
     * @param feedbackcomment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Feedbackcomment> edit(@RequestBody Feedbackcomment feedbackcomment) {
        return ResponseEntity.ok(this.feedbackcommentService.update(feedbackcomment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.feedbackcommentService.deleteById(id));
    }

}

