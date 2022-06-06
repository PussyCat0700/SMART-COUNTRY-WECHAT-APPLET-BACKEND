package com.miniprogram.zhihuicunwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.entity.Comment;
import com.miniprogram.zhihuicunwu.entity.User;
import com.miniprogram.zhihuicunwu.service.CommentService;
import com.miniprogram.zhihuicunwu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2022-06-06 21:32:13
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param mid 主键
     * @return 单条数据
     */
    @GetMapping("{mid}")
    public ResponseEntity<List> queryById(@PathVariable("mid") Integer mid) {
        Comment c1 = new Comment();
        c1.setMid(mid);
        List<Comment> comments = this.commentService.queryAllByAny(c1);
        List<JSONObject> ret = new ArrayList<>();
        for(Comment comment:comments){
            JSONObject item = new JSONObject();
            item.put("replyContent", comment.getContent());
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
    public ResponseEntity<Comment> add(@RequestBody JSONObject jsonObject) {
        Comment comment = new Comment();
        comment.setContent(jsonObject.getString("replyContent"));
        comment.setUid(jsonObject.getInteger("userID"));
        comment.setReplyUid(jsonObject.getInteger("replyUserID"));
        return ResponseEntity.ok(this.commentService.insert(comment));
    }

    /**
     * 编辑数据
     *
     * @param comment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Comment> edit(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.commentService.update(comment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.commentService.deleteById(id));
    }

}

