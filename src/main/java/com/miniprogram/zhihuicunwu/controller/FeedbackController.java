package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Feedback;
import com.miniprogram.zhihuicunwu.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Feedback)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
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

    //查询所有数据
    @GetMapping("/all")
    public ResponseEntity<List> queryAll()
    {
        return ResponseEntity.ok(this.feedbackService.queryAll());
    }

//    public List<Feedback> queryAll()
//    {
//        return this.feedbackService.queryAll();
//    }

    //模糊查询
    @GetMapping("/fuzzy/{content}")
    public ResponseEntity<List> queryFuzzyByContent(@PathVariable("content") String content)
    {
        return ResponseEntity.ok(this.feedbackService.queryFuzzyByContent(content));
    }

//    public List<Feedback> queryFuzzyByContent(String content)
//    {
//        return this.feedbackService.queryFuzzyByContent(content);
//    }

    //我的反馈列表，根据uid查询相关的反馈
    @GetMapping("/myfeedback/{uid}")
    public ResponseEntity<List> queryFeedbackByUid(@PathVariable("uid") int uid)
    {
        return ResponseEntity.ok(this.feedbackService.queryFeedbackByUid(uid));
    }



    /**
     * 新增数据
     *
     * @param feedback 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Feedback> add(@RequestBody JSONObject params) throws ParseException {
        Feedback feedback = new Feedback();
        feedback.setUid(params.getInteger("uid"));
        feedback.setPid(params.getInteger("related_article"));
        feedback.setFcontent(params.getString("content"));
        feedback.setFreturn("");

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

