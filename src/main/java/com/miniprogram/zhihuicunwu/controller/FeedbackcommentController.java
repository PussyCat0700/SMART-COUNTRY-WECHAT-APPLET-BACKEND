package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Feedbackcomment;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.FeedbackcommentService;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Feedbackcomment)表控制层
 *
 * @author makejava
 * @since 2022-06-12 16:23:47
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
     * 通过主键查询单条数据
     *
     * @param pid 主键
     * @return 单条数据
     */
    @GetMapping("{pid}")
    public ResponseEntity<List> queryById(@PathVariable("pid") Integer pid) {
        Feedbackcomment c1 = new Feedbackcomment();
        c1.setPid(pid);
        List<Feedbackcomment> comments = this.feedbackcommentService.queryAllByAny(c1);
        List<JSONObject> ret = new ArrayList<>();
        for(Feedbackcomment comment:comments){
            JSONObject item = new JSONObject();
            item.put("replyContent", comment.getContent());
            item.put("commentID", comment.getCommentId());
            User u = this.userService.queryById(comment.getUid());
            if(u!=null) {
                item.put("userInfo", u.getBriefInfo());
            }
            if(comment.getReplyUid()!=null){
                User u2 = this.userService.queryById(comment.getReplyUid());
                item.put("replyUserInfo", u2.getBriefInfo());
            }
            ret.add(item);
        }
        return ResponseEntity.ok(ret);
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
        feedbackcomment.setContent(jsonObject.getString("replyContent"));
        feedbackcomment.setUid(jsonObject.getInteger("userID"));
        feedbackcomment.setReplyUid(jsonObject.getInteger("replyUserID"));
        feedbackcomment.setPid(jsonObject.getInteger("pid"));
        feedbackcomment.setReplyCommentId(jsonObject.getInteger("replyCommentID"));
        return ResponseEntity.ok(this.feedbackcommentService.insert(feedbackcomment));
    }

    /**
     * 编辑数据
     *
     * @param feedbackcomment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Feedbackcomment> edit(Feedbackcomment feedbackcomment) {
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

