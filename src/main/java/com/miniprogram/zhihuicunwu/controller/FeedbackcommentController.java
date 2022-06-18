package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Feedbackcomment;
import com.miniprogram.zhihuicunwu.service.FeedbackcommentService;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;
import java.util.List;

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
    @Resource
    private UserService userService;

    /**
     * 通过主键查询多条数据
     *
     * @param fid 主键
     * @return 多条数据
     */
    @GetMapping("{fid}")
    public ResponseEntity<JSONArray> queryById(@PathVariable("fid") Integer fid) {
        Feedbackcomment feedbackcomment = new Feedbackcomment();
        feedbackcomment.setFid(fid);
        List<Feedbackcomment> feedbackcommentList = this.feedbackcommentService.queryAllByAny(feedbackcomment);
        JSONArray jsonArray= new JSONArray();
        if(feedbackcommentList!=null&&!feedbackcommentList.isEmpty()) {
            for(Feedbackcomment feedbackcomment1:feedbackcommentList) {
                JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(feedbackcomment1));
                jsonObject.replace("commentTime", feedbackcomment1.getCommentTime());
                jsonObject.put("userInfo", userService.queryById(feedbackcomment1.getUid()).getBriefInfo());
                jsonArray.add(jsonObject);
            }
        }
        return ResponseEntity.ok(jsonArray);
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
        feedbackcomment.setCommentTime(Date.from(Instant.now()));
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

