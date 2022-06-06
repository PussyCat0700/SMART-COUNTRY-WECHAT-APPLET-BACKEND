package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Feedback;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.FeedbackService;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
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
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<JSONObject> queryById(@PathVariable("id") Integer id) {
        JSONObject jsonObject = new JSONObject();
        Feedback feedback = this.feedbackService.queryById(id);
        if(feedback!=null) {
            jsonObject.put("content", feedback.getFcontent());
            jsonObject.put("date", feedback.getFtime());
            jsonObject.put("related_article", feedback.getPid());
            User user = this.userService.queryById(feedback.getUid());
            JSONObject userInfo = new JSONObject();
            if (user != null) {
                userInfo.put("userName", user.getUname());
            }
            jsonObject.put("userInfo", userInfo);
        }
        return ResponseEntity.ok(jsonObject);
    }

    //查询所有数据
    @GetMapping("/all")
    public ResponseEntity<List> queryAll() throws SQLException
    {
        List<JSONObject> ret = new ArrayList<JSONObject>();
        List<Feedback> feedbacks = this.feedbackService.queryAll();

        for(int i = 0; i < feedbacks.size(); i++)
        {
            User user = userService.queryById(feedbacks.get(i).getUid());
            JSONObject user_info = new JSONObject();
            String avartar = user.getUphoto();

            user_info.put("avatarUrl", avartar);

            JSONObject temp = new JSONObject();
            temp.put("id", feedbacks.get(i).getFid());
            temp.put("content", feedbacks.get(i).getFcontent());
            temp.put("related_article", feedbacks.get(i).getPid());
            temp.put("date", feedbacks.get(i).getFtime());
            temp.put("userInfo", user_info);

            ret.add(temp);
        }

        return ResponseEntity.ok(ret);
    }

//    public List<Feedback> queryAll()
//    {
//        return this.feedbackService.queryAll();
//    }

    //模糊查询
    @GetMapping("/fuzzy/{content}")
    public ResponseEntity<List> queryFuzzyByContent(@PathVariable("content") String content)
    {
        List<JSONObject> ret = new ArrayList<JSONObject>();
        List<Feedback> feedbacks = this.feedbackService.queryFuzzyByContent(content);

        for(int i = 0; i < feedbacks.size(); i++)
        {
            User user = userService.queryById(feedbacks.get(i).getUid());
            JSONObject user_info = new JSONObject();
            String avartar = user.getUphoto();

            user_info.put("avatarUrl", avartar);
            user_info.put("nickName", user.getUname());

            JSONObject temp = new JSONObject();
            temp.put("id", feedbacks.get(i).getFid());
            temp.put("content", feedbacks.get(i).getFcontent());
            temp.put("related_article", feedbacks.get(i).getPid());
            temp.put("date", feedbacks.get(i).getFtime());
            temp.put("userInfo", user_info);

            ret.add(temp);
        }

        return ResponseEntity.ok(ret);
    }

//    public List<Feedback> queryFuzzyByContent(String content)
//    {
//        return this.feedbackService.queryFuzzyByContent(content);
//    }

    //我的反馈列表，根据uid查询相关的反馈
    @GetMapping("/myfeedback/{uid}")
    public ResponseEntity<List> queryFeedbackByUid(@PathVariable("uid") int uid)
    {
        List<JSONObject> ret = new ArrayList<JSONObject>();
        List<Feedback> feedbacks = this.feedbackService.queryFeedbackByUid(uid);

        for(int i = 0; i < feedbacks.size(); i++)
        {
            JSONObject temp = new JSONObject();
            temp.put("feedback_id", feedbacks.get(i).getFid());
            temp.put("content", feedbacks.get(i).getFcontent());
            temp.put("create_time", feedbacks.get(i).getFtime());

            ret.add(temp);
        }

        return ResponseEntity.ok(ret);
    }



    /**
     * 新增数据
     *
     * @param params 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Feedback> add(@RequestBody JSONObject params) {
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

